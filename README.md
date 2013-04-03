Heroku Java Facebook Template
=============================

This java template web application uses spring social for facebook integration, the
ruby gem sequel for database migrations and jersey for json and rest api. It is
basically a modified version of a spring-social sample project.

## Deploying to heroku

To deploy, you need to install the heroku command line interface and create an account on heroku.

    $ heroku create my-social-app
    $ heroku config --app my-social-app
    $ export DATABASE_URL=postgres...
    $ rake db:migrate:up

## Running locally on OSX

To make environment variables accessible from Eclipse, run:

    $ sudo vi /etc/launchd.conf

Then add this two lines:

    setenv LOCAL_TEMPLATE_DATABASE_URL postgres://username:password@host:5432/basenavn
    setenv REMOTE_TEMPLATE_DATABASE_URL postgres://username:password@host:5432/basenavn

## Prepare PostgresSQL locally

To install PostgreSQL locally on OSX Lion use the installer from http://postgresapp.com/
Older versions of OSX can install via homebrew:

    $ brew install postgresql

Then create user and a database:

    $ createuser boligpriser --no-superuser --no-createrole --createdb


## Running locally from within Eclipse

The simple Eclipse plugin "Run Jetty Run" can be used to run the webapp.
It uses Java HotSwap so you don't have to restart the web app if you've only done
small changes to the java code.

## Migrations

Migration scripts are written in ruby and the sequel rubygems.
On OSX ruby is preinstalled. On Windows I can recommend  http://railsinstaller.org.
To run the migration:

    $ export DATABASE_URL=postgres://username:password@host:5432/basenavn
    $ rake db:migrate:up

## Architecture

The application uses the following libs:

 * REST kall bruker jersey og jackson

Spring Social Quickstart
========================
This sample is designed to get you up and running quickly.
See the walkthrough at: https://github.com/SpringSource/spring-social/wiki/Quick-Start

To run, simply import the project into your IDE and deploy to a Servlet 2.5 or > container such as Tomcat 6 or 7.
You can also deploy from the command line with:
$ mvn tomcat:run

Access the project at http://localhost:8080/spring-social-quickstart

Discuss at forum.springsource.org and collaborate with the development team at jira.springframework.org/browse/SOCIAL.
