require 'rspec/core'
require 'rspec/core/rake_task'
require 'sequel'
require 'pry'

RSpec::Core::RakeTask.new(:spec) do |spec|
  spec.pattern = FileList['spec/**/*_spec.rb']
  spec.rspec_opts = ['--backtrace']
end

task :default => :spec

namespace :db do
  require "sequel"

  DATABASE_URL = ENV['DATABASE_URL']
  DB = Sequel.connect(DATABASE_URL)

  desc "Start sequel console"
  task :console do
  end

  namespace :migrate do
    Sequel.extension :migration

    desc "Perform migration reset (full erase and migration up)"
    task :reset do
      Sequel::Migrator.run(DB, "db/migrations", :target => 0)
      Sequel::Migrator.run(DB, "db/migrations")
      puts "<= sq:migrate:reset executed"
    end

    desc "Perform migration up/down to VERSION"
    task :to do
      version = ENV['VERSION'].to_i
      raise "No VERSION was provided" if version.nil?
      Sequel::Migrator.run(DB, "db/migrations", :target => version)
      puts "<= sq:migrate:to version=[#{version}] executed"
    end

    desc "Perform migration up to latest migration available"
    task :up do
      Sequel::Migrator.run(DB, "db/migrations")
      puts "<= sq:migrate:up executed"
    end

    desc "Perform migration down (erase all data)"
    task :down do
      Sequel::Migrator.run(DB, "db/migrations", :target => 0)
      puts "<= sq:migrate:down executed"
    end

    # Custom tasks for event harvesting
    desc "Empty all events"
    task :empty do
      events = DB[:events]
      events.delete
      venues = DB[:venues]
      venues.delete
      locations = DB[:locations]
      locations.delete
      sources = DB[:sources]
      sources.delete
      puts "<= sq:migrate:empty executed - database emptied"
    end


  end
end
