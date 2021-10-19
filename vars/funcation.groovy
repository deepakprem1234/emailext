def emailtext ():
            {
                def subject = "FAILED: Job at STAGE ${env.STAGE_NAME} ${env.JOB_NAME} - ${env.BUILD_NUMBER}"
                def body = """<br><p><p>Check console output at &QUOT;<a href='${env.BUILD_URL}console'>${env.JOB_NAME} - ${env.BUILD_NUMBER}</a>&QUOT;</p><br>""",
                to: """${env.QA_MAIL_ID}""", mimeType: 'text/html', recipientProviders: [[$class: 'DevelopersRecipientProvider']]

             emailext (
                subject: subject,
                attachLog: true, attachmentsPattern: '*.log',
                body:body   )
        }
