package com.qaprosoft.jenkins.repository.jobdsl

@Grab('org.testng:testng:6.3.1')

import groovy.io.FileType;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;
import com.qaprosoft.jenkins.repository.jobdsl.Job;


createJob()


void createJob() {
	def workspace = binding.variables.WORKSPACE


        def jobFolder = binding.variables.jobFolder
        def project = binding.variables.project
        def sub_project = binding.variables.sub_project
	def suite = binding.variables.suite
        def suiteOwner = binding.variables.suiteOwner
        def zafira_project = binding.variables.zafira_project
        def createCron = binding.variables.createCron



	def suiteTmpPath = "${workspace}/suite.xml"

	File file = new File(suiteTmpPath)
	file.write(binding.variables.suiteXML)

        def xmlFile = new Parser(new File(suiteTmpPath).absolutePath)
        xmlFile.setLoadClasses(false)

        List<XmlSuite> suiteXml = xmlFile.parseToList()
        XmlSuite currentSuite = suiteXml.get(0)


        def jobName = currentSuite.getParameter("jenkinsJobName").toString()
        Job.createPipeline(pipelineJob(jobFolder + "/" + jobName), currentSuite, project, sub_project, suite, suiteOwner, zafira_project)

	if (createCron && !currentSuite.getParameter("jenkinsRegressionPipeline").toString().contains("null")) {
		def cronJobName = currentSuite.getParameter("jenkinsRegressionPipeline").toString()
		Job.createRegressionPipeline(pipelineJob(jobFolder + "/" + cronJobName), currentSuite, project, sub_project)
	}
}
