package com.qaprosoft.selenium.grid

import com.qaprosoft.Logger
import com.qaprosoft.jenkins.jobdsl.factory.DslFactory
import groovy.json.JsonSlurper

class ProxyInfo extends DslFactory{

    def private static platformDeviceListMap = ["android":[], "ios":[]]
    def private static baseDeviceList = ["DefaultPool", "ANY"]
    def private static _dslFactory = super._dslFactory


	//TODO: reused grid/admin/ProxyInfo to get atual list of iOS/Android devices
	public static List<String> getDevicesList(String selenium, String platform) {

        //TODO: reuse selenium host/port/protocol from env jobVars
		def proxyInfoUrl = selenium + "/grid/admin/ProxyInfo"
        def deviceList = platformDeviceListMap.get(platform.toLowerCase())
        Logger.setOutput(_dslFactory)
        Logger.log("Logger works!")
		try {
            if (deviceList.size() == 0) {
                def json = new JsonSlurper().parse(proxyInfoUrl.toURL())
                json.each {
                    if (platform.equalsIgnoreCase(it.configuration.capabilities.platform)) {
                        _dslFactory.println("platform: " + it.configuration.capabilities.platform[0] + "; device: " + it.configuration.capabilities.browserName[0])
                        deviceList.add(it.configuration.capabilities.browserName[0]);
                    }
                }
            }
		} catch (Exception e) {
			//TODO: find a way to write message in static methods
			println(e.getMessage())
		}
		return baseDeviceList + deviceList.sort()
	}
}