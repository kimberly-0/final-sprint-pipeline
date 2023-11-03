pipeline {
  agent any

  stages {
    stage('Checkout') {
      steps {
        // Get code from a GitHub repository
        git branch: 'main', url: 'https://github.com/kimberly-0/final-sprint.git'
      }
    }
    stage('Install and test back-end') {
        steps {
          // Change directory to the front-end folder
            sh "cd lbg-car-spring-app-starter"
            // Install the ReactJS dependencies
            sh "mvn clean compile"
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
            sh "npm install"
            // Run the ReactJS tests
            sh "npm test"
            // Change directory to the parent folder
            sh "cd .."
        }
    }
    stage('Push docker images and cleanup') {
        steps {
          
        }
    }
    stage('Deploy to server') {
        steps {
          
        }
    }
  }
}