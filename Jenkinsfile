pipeline {
    agent any
    options {
        skipStagesAfterUnstable()
    }
    stages {
        stage('Gradle Build') {
            steps {
                sh './gradlew clean build'
            }
        }
        stage('Test'){
            steps {
                sh 'make check'
                junit 'reports/**/*.xml'
            }
        }
        stage('Deploy') {
            steps {
                sh 'make publish'
            }
        }
    }
}