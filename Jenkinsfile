pipeline
{
    agent any

    tools{
        maven 'maven'
        }

    stages
    {
        stage('Build')
        {
            steps
            {
                  echo("build is ready")
            }
        }


        stage('Automation Tests') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                   git 'https://github.com/udaysinghc/rezysaveautomation.git'
                    bat "mvn clean test"

                }
            }
        }



        stage('Publish sanity Extent Report'){
            steps{
                     publishHTML([allowMissing: false,
                                  alwaysLinkToLastBuild: false,
                                  keepAll: true,
                                  reportDir: 'reports',
                                  reportFiles: 'TestExecutionReport.html',
                                  reportName: 'HTML Sanity Extent Report',
                                  reportTitles: ''])
                                   