pipeline {
  agent any
  stages {
    stage('clean proj') {
      steps {
        sh './gradlew compileDebugSources'
        echo 'sucsess'
      }
    }

  }
}