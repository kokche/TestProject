pipeline {
  agent any
  stages {
    stage('clean proj') {
      steps {
        sh 'bash ./gradlew compileDebug --stacktrace'
        echo 'sucsess'
      }
    }

  }
}