pipeline {
  agent any

  tools {
    // Install the Maven version configured as "M3" and add it to the path.
    maven "M3"
  }

  environment {
      SERVER_URL = "http://35.210.48.104:8000/" // IP of target deployment server
  }

  stages {
    stage('Checkout') {
      steps {
         dir('lbg-car-spring-app-starter') {
            // Get back-end code from a GitHub repository
            git branch: 'main', url: 'https://github.com/BNeermul/lbg-car-spring-app-starter.git'
        }
        dir('lbg-car-react-starter') {
            // Get front-end code from a GitHub repository
            git branch: 'main', url: 'https://github.com/BNeermul/lbg-car-react-starter.git'
        }
      }
    }
    stage('Install and test front-end') {
        steps {
            dir('lbg-car-react-starter') {
                // Install the ReactJS dependencies
                sh "yarn install"
                
                // Yarn to install npm modules
    
                // Run the ReactJS tests
                sh "yarn test"
                // // Switch jenkins user
                // sh "sudo su jenkins"
                // Docker build
                sh "docker build -t kimberly0/final-sprint-front-end:v1 ."
                // // Exit jenkins user
                // sh "exit"
            }
        }
    }
    stage('Install and test back-end') {
        steps {
            dir('lbg-car-spring-app-starter') {
                // Install the dependencies
                sh "mvn clean compile"
                // Run the tests
                sh "mvn test"
                // // Switch jenkins user
                // sh "sudo su jenkins"
                // Print current user
                sh "echo 'user: '"
                sh "whoami"
                // Docker build
                sh "docker build -t kimberly0/final-sprint-back-end:v1 ."
                // // Exit jenkins user
                // sh "exit"
            }
        }
    }
   
    // stage('Push docker images and cleanup') {
    //     steps {
    //       // Push docker images

    //       // Clean up docker

    //     }
    // }
    stage('Deploy to server') {
        steps {
          sh "docker compose up -d --build"
        }
    }
  }
}