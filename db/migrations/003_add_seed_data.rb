Sequel.migration do

  up do
    brukere = DB[:brukere]
    brukere.insert(:bruker_id => 1, :brukernavn => "thomasfl")
    brukere.insert(:bruker_id => 2, :brukernavn => "sebastianfh")
    brukere.insert(:bruker_id => 3, :brukernavn => "elisehf")
    brukere.insert(:bruker_id => 4, :brukernavn => "annikenfg")
    brukere.insert(:bruker_id => 5, :brukernavn => "tbn")
  end

  down do
    brukere = DB[:brukere]
    [1,2,3,4,5].each do |bruker_id|
      brukere.where("\"bruker_id\" = ?",bruker_id).delete
    end
  end

end
