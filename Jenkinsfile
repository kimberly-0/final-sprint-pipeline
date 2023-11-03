pipeline {
  agent any

  tools {
    // Install the Maven version configured as "M3" and add it to the path.
    maven "M3"
  }

  stages {
    stage('Checkout') {
      steps {
        // Get back-end code from a GitHub repository
        git branch: 'main', url: 'https://github.com/BNeermul/lbg-car-spring-app-starter.git'
        // Get front-end code from a GitHub repository
        git branch: 'main', url: 'https://github.com/BNeermul/lbg-car-react-starter.git'
      }
    }
    stage('Install and test back-end') {
        steps {
            // Change directory to the back-end folder
            sh "cd lbg-car-spring-app-starter"
            // Install the dependencies
            sh "mvn clean compile"
            // Run the tests
            sh "mvn test"
            // Docker build
            sh "docker build -t kimberly0/final-sprint-back-end:v1 ."
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
            
            // Yarn to install npm modules

            // Run the ReactJS tests
            sh "yarn test"
            // Docker build
            sh "docker build -t kimberly0/final-sprint-front-end:v1 ."
            // Change directory to the parent folder
            sh "cd .."
        }
    }
    stage('Push docker images and cleanup') {
        steps {
          // Push docker images

          // Clean up docker

        }
    }
    stage('Deploy to server') {
        steps {
          sh "docker compose up -d --build"
        }
    }
  }
}