# CurrenciesServer
Crossover Test

## How to use Vagrant

Vagrant is a tool for building and distributing development environments.

Documentation is located in: [https://docs.vagrantup.com/v2/](https://docs.vagrantup.com/v2/ "Vagrant Documentation")

You need to install Chef-dk (https://downloads.chef.io/chef-dk) and vagrant-berkshelf:

```
vagrant plugin install vagrant-berkshelf
```

## Run Vagrant 

```
cd /path/to/CurrenciesServer/
vagrant up
vagrant ssh
```

## Run Application

```
vagrant ssh
cd /CurrenciesServer/
gradle run
```

## Visit Application

Visit URL
```
http://192.168.33.20:8080/currencies
```

# Build WAR (production environment)
```
vagrant ssh
cd /CurrenciesServer/
gradle war 
```

# PROBLEMS?

# Introduction
You have just created an Angular Grails application using lazybones.

For more detailed information see:
https://github.com/craigburke/lazybones-angular-grails

# Running the application
	gradlew run

# Running tests
	gradlew test

# Generate blank application
        lazybones generate module::blank

# Generate REST application
	* Create a domain class:
	gradlew grails-create-domain-class -PgrailsArgs=Foo

	* Generate your angular module:
	lazybones generate module