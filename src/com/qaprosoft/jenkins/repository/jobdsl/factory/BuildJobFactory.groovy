package com.qaprosoft.jenkins.repository.jobdsl.factory

import groovy.transform.*

@InheritConstructors
public class BuildJobFactory extends JobFactory {

    protected def binding

    JobFactory(dslFactory){
        this.binding = binding
    }

	def emptyJob(_name, _description) {
		def job = myJob(_name, _description)
		job.with {
            logRotator { numToKeep 100 }
		}
		return job
	}

	def jobWithParameter(_name, _description) {
		def job = myJob(_name, _description)
		job.with {
            logRotator { numToKeep 100 }
            parameters {
                booleanParam('parameterIsHere', true, 'First factory parameter')
            }
		}
		return job
	}
}