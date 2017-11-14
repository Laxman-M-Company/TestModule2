pipeline {
    agent any

    stages {
        stage('check out') {
            steps {
                git credentialsId: '79e4b276-fa9a-4e43-a98b-286ed3c96695', url: 'ssh://APKAJ4TVQ2TVX7BYBUGA@git-codecommit.ap-southeast-1.amazonaws.com/v1/repos/msl-starling-android'
            }
        }
        stage('module unit tests') {
            steps {
                sh './run-module-unit-tests.sh'
            }
        }
        stage('test mi') {
            steps {
                sh './gradlew clean testMiMockDebugUnitTest connectedMiMockDebugAndroidTest'
            }
        }
        stage('test sq') {
            steps {
                sh './gradlew clean testSqMockDebugUnitTest connectedSqMockDebugAndroidTest'
            }
        }
        stage('deploy mi') {
            steps {
                sh './gradlew assembleMiUatDebug crashlyticsUploadDistributionMiUatDebug'
            }
        }
        stage('deploy sq') {
            steps {
                sh './gradlew assembleSqUatDebug crashlyticsUploadDistributionSqUatDebug'
            }
        }
    }
}
