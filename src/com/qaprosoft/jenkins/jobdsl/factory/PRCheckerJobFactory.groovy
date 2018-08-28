package com.qaprosoft.jenkins.jobdsl.factory

import com.qaprosoft.jenkins.jobdsl.factory.pipeline.PipelineFactory
import groovy.transform.InheritConstructors
@Grab('org.testng:testng:6.8.8')

import org.testng.xml.Parser
import org.testng.xml.XmlSuite

@InheritConstructors
public class PRCheckerJobFactory extends PRCheckerFactory {

    def project
    def sub_project

    public PRCheckerJobFactory(folder, project, sub_project, jobDesc) {
        this.folder = folder
        this.description = jobDesc
        this.project = project
        this.sub_project = sub_project
    }

    def create() {

        def prCheckerJob = super.create()

        prCheckerJob.with {
            parameters {
                configure addExtensibleChoice('project', "gc_GIT_PROJECT", '', project)
                configure stringParam('sub_project', '.', sub_project)
            }
        }
        return prCheckerJob
    }

}