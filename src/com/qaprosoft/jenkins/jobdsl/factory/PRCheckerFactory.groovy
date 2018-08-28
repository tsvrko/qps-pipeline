package com.qaprosoft.jenkins.jobdsl.factory

import com.qaprosoft.jenkins.jobdsl.factory.job.JobFactory
import groovy.transform.InheritConstructors

@InheritConstructors
class PRCheckerFactory extends JobFactory {



    public PRCheckerFactory(folder, name, description) {
        super(folder, name, description)
    }

    public PRCheckerJobFactory(folder, project, sub_project, jobDesc) {
        this.folder = folder
        this.description = jobDesc
        this.project = project
        this.sub_project = sub_project
    }
}
