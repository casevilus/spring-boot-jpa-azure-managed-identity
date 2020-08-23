# Multi-module SpringBoot Docker Application

This example shows to build multiple containers for a multi-module project in Gradle

# How the example is setup

The project consists of one microservice and library

  1. `common` - a project dependency used by `microservice`
  1. `microservice` - responds with a greeting
  
 
The **Gradle** project is set up with a parent [`build.gradle`](build.gradle) that sets some common configuration up for all projects, with each sub-project containing its own `build.gradle` with some custom configuration. [`settings.gradle`](settings.gradle) defines which modules to include in the overall build.

## Reproducibility of dependency module `common`

Since dependency module builds happen with the underlying build system
(gradle), we must add some extra configuration to ensure that the
resulting `jar` that is built conforms to our reproducibility expectations.
The module [`common`](common) uses some special `Jar` properties ([`preserveFileTimestamps`](https://docs.gradle.org/current/dsl/org.gradle.api.tasks.bundling.Jar.html#org.gradle.api.tasks.bundling.Jar:preserveFileTimestamps),
[`reproducibleFileOrder`](https://docs.gradle.org/current/dsl/org.gradle.api.tasks.bundling.Jar.html#org.gradle.api.tasks.bundling.Jar:reproducibleFileOrder))
in gradle to achieve this. This configuration can be seen in the
`common`'s [`build.gradle`](common/build.gradle).

Care must be taken when adding custom attributes to a `MANIFEST.MF`.
Attributes whose values change on every build can affect reproducibility even
with the modifications outlined aboved.

# How to run

Set the `SERVER_PORT`, `MGMT_SERVER_PORT_`, `SERVER_ADDR` environment variables

```shell
export $(cat .env | xargs)

```

Run the **Gradle** build:

```shell
# build everything
./gradlew jibDockerBuild

# build just hello-service
./gradlew :microservice:jib
```

You can also run `./gradle-build.sh` as a shorthand.

# Where are the containers

The output of the build should have the container image references highlighted in <span style="color: cyan">cyan</span>. You can expect them to be at:

- `microservice`: `demo-ixcc-app`

# How to run on Kubernetes

[`kubernetes.yaml`](kubernetes.yaml) defines the manifests for running the microservice on Kubernetes. 

Apply to your Kubernetes cluster:

```shell
helm install 
```

Find the `EXTERNAL-IP` of the `ixcc-demo-app`.

```
NAME                TYPE           CLUSTER-IP      EXTERNAL-IP     PORT(S)        AGE
svc/hello-service   LoadBalancer   10.19.243.223   35.237.89.148   80:30196/TCP   1m
```

Visit the IP in your web browser and you should see:

```
{"id":1,"content":"Hello, Stranger!"}
```  