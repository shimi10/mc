arti = userInput(type: "ARTIFACTORY", description: "Artifactory")
baseUserName = userInput(type: "STRING", description: "Base User Name")
numOfUsers = userInput(type: "INTEGER", description: "Number Of Users to Create")      

                         
artifactory(arti.name) {
  security {
    users {
      for (i in 1..numOfUsers){
        user(baseUserName + i) {
         email baseUserName + '_' + i + '@jfrog.com'
        password 'password'
        admin false
        profileUpdatable false
        internalPasswordDisabled false
      }
    }
  }
}

}