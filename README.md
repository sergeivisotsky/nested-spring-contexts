## Nested Spring Contexts

The following application is supposed to show how is it possible to run a different applications with each own context
under a single context.

By doing this it is possible to isolate a functionality from each other in case if multiple microservices needs to be
bumped up into a single unit but be still loosely coupled. This approach allows to have a services in a single unit as
well separating them as soon as it is required when a load increases on some part as an example.

Modules:

* spring-boot-config - library which contains main Boostrap class initializes a root context and BootstrapBean which
  should extend all child contexts
* first-app - an application which holds a separate context and is being initialized in a separate context
* second-app - same as first-app
* orchestra-app - application which holds both first-app and second-app and run them under a single context but still
  each of them has its own context

