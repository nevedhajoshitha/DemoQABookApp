pipeline {
    agent {
        docker {
            image 'maven:3.9.6-eclipse-temurin-17'
        }
    }

    stages {
        stage('Checkout') {
            steps {
                // Pull code from Git
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                // Run Maven build & tests inside container
                sh 'mvn clean test'
            }
        }

        stage('Report') {
            steps {
                // Archive test results & HTML reports
                junit '**/target/surefire-reports/*.xml'
                publishHTML([allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target',
                    reportFiles: 'ExtentReport.html',
                    reportName: 'Extent Report'])
            }
        }
    }
}