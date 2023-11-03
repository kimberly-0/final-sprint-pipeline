pipeline {
  agent any

  stages {
    stage('Checkout') {
      steps {
        // Get code from a GitHub repository
        git branch: 'main', url: 'https://github.com/XXXXXXXXXXXXXXXXXX'
      }
    }
    stage('Install and test back-end') {
        steps {
          // Change directory to the front-end folder
            sh "cd lbg-car-spring-app-starter"
            // Install the ReactJS dependencies
            sh "mvn install"
            // Run the ReactJS tests
            sh "mvn test"
            // Change directory to the parent folder
            sh "cd .."
        }
    }
    stage('Install and test front-end') {
        steps {
            // Change directory to the front-end folder
            sh "cd lbg-car-react-starter"
            // Install the ReactJS dependencies
            sh "yarn install"
            // Run the ReactJS tests
            sh "yarn test"
            // Change directory to the parent folder
            sh "cd .."
        }
    }
  }
}