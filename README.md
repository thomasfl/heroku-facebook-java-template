Boligpriser.no
==============

## Kom i gang med heroku

Slik kan du deploye denne koden til heroku: 

    $ heroku create boligpriser-staging
    $ heroku config --app boligpriser-staging
    $ export DATABASE_URL=postgres...
    $ rake db:migrate:up

## Installer og kjør lokalt OSX

Sett opp miljøvariablene så de er tilgjengelig både fra kommandolinjen og applikasjoner som Eclipse ved å legge inn

    setenv LOCAL_BOLIGER_DATABASE_URL postgres://brukernavn:passord@host:5432/basenavn
    setenv REMOTE_BOLIGER_DATABASE_URL postgres://brukernavn:passord@host:5432/basenavn

## Preparer database

For å installere PostgreSQL lokalt På OSX på Lion eller senere anbefals http://postgresapp.com/
For eldre versjoner av OSX, kan man installere med homebrew:

    $ brew install postgresql

Opprett bruker og database

    $ createuser boligpriser --no-superuser --no-createrole --createdb


## Kjøre lokalt fra Eclipse

Kan anbefale en Eclipse plugin ved navn "Run Jetty Run" for å kjøre webapplikasjonen fra Eclipse.
Den benytter Java HotSwap så man slipper å ta omstart hvis man har gjort noen små endringer i javakoden.

## Migreringer

Migreringsscriptene er skrevet i ruby og bruker biblioteket sequel. For å kjøre migreringsscriptene lokalt må først ruby installeres. På OSX er ruby allerede installert. På Windows anbefales http://railsinstaller.org.

## Arkitektur

Nettstedet er utviklet i java og bruker disse bibliotekene:

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
