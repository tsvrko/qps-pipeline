package com.qaprosoft.jenkins.repository.jobdsl.factory

public class JobFactory {

    protected def dslFactory

    JobFactory(dslFactory){
        this.dslFactory = dslFactory
        this.binding = binding
    }

    def myJob(_name, _description) {
        return dslFactory.freeStyleJob(_name){
            description "DSL MANAGED: - $_description"
            logRotator { numToKeep 100 }
        }
    }

}