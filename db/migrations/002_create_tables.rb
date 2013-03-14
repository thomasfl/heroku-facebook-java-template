Sequel.migration do
  up do
    create_table(:brukere) do
      primary_key :bruker_id
      String :brukernavn, :null=>false
      String :fornavn
      String :etternavn
      String :epost
      DateTime :registrert
      DateTime :oppdatert
      Integer :alder
      Boolean :eier_egen_bolig
      Boolean :eier_sekundar_bolig
      Integer :fylke_id
    end

    alter_table(:brukere) do
      add_index :registrert
      add_index :oppdatert
      add_index :alder
      add_index :eier_egen_bolig
      add_index :eier_sekundar_bolig
      add_index :fylke_id
    end

    create_table(:prediksjoner) do
      primary_key :prediksjon_id
      Float :endring
      Integer :type
      Integer :bruker_id
      Integer :periode_id
    end

    alter_table(:prediksjoner) do
      add_index :type
      add_index :periode_id
    end

    create_table(:perioder) do
      primary_key :periode_id
      DateTime :periode_start
    end

  end

  down do
    drop_table(:brukere)
    drop_table(:prediksjoner)
    drop_table(:perioder)
  end

end
