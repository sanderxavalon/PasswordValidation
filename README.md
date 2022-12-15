# Password Validation for Innova

- [Quick Start](#quick-start)
- [About](#about)


## Quick Start

This project use `Maven` as build tool, I highly recommend `3.6.x` version for this project.

```bash
mvn spring-boot:run
```

If you just want to run unit test, then

```bash
mvn test
```

## About

The project followed requirement from the assignment, build by several design pattern.

- Chain of responsibility
All the validation class will implement the abstract class `PasswordValidator`, which had defined the behavior of all the sub-class. All these validator class will automatically be injected into `PasswordValidationService` by Spring(Constructor injection), and concat all the validator in order(`@Order` annotation will make Spring inject bean in order). You may remove/insert any validator or change the order anytime you like.
- Observer
Instead of declare MIN/MAX value as final field in class, I decide to make the Max/Min word limitation store in database(`Config` table). Once the value change, the Observer will notify all the subscriber to update their status(In this case, Min/Max word limitation), so we can easily add more config if needed. Also, the subscriber must be initialized first, then initialize observer(in this case, `ConfigService`), otherwise we will meet circular dependencies issue. So I add `@Lazy` annotation on `ConfigService`, it will be initialized once we need it. 
