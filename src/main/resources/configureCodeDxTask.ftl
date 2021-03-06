<ww:head theme="ajax"/>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous"/>
<style>

    .setting-section {
        display: flex;
        padding: 5px 0px 5px 0px;
    }

    .setting-textfield {
        /* The max-width of the textfields */
        width: 250px;
    }

    .setting-checkbox {
        width: fit-content;
    }

    .setting-help-textfield {
        opacity: 0.75;
        color: #205081;
        font-size: 1.25rem;
        cursor: pointer;
        padding: 5px;
        align-self: flex-end;
    }

    .setting-help-checkbox {
        opacity: 0.75;
        color: #205081;
        font-size: 1.25rem;
        cursor: pointer;
        padding: 0px 0px 0px 5px;
        align-self: flex-end;
    }

    .setting-content {
        display: none;
        border: 1px solid #CCC;
        border-radius: 3.01px;
        padding: 5px;
        background: #EEE;
		width: 90%;
        max-width: 740px;
    }

    .setting-button {
        opacity: 0.75;
        background-color: #205081;
        color: white;
        font-size: 0.8rem;
        border-radius: 3.01px;
        cursor: pointer;
        margin: 31px 0px 0px 5px;
        align-self: flex-start;
        padding: 5px;
    }

    code {
        width: fit-content;
        padding-right: 15px;
    }

</style>

<h2>Code Dx Server Settings</h2>

<!--Use Admin Defaults-->
<div class="setting-section" id="useAdminDefaultSection">
	<div class="setting-checkbox">
		[@ww.checkbox id="useDefaultCheckbox" label="Use Default Code Dx Settings" name="useDefaults" onclick="toggleUseDefaults()"/]
	</div>
	<span id="help-button-use-defaults" class="setting-help-checkbox" onclick="toggleHelp(this)">
        <i class="fas fa-question-circle"></i>
    </span>
</div>
<div id="help-content-use-defaults" class="setting-content">
    <span>When checked, this task will use the values saved in the plugin admin page for the Code Dx URL, api key, and self-signed fingerprint.</span>
    <span>Un-checking allows to override these settings for this task.</span>
</div>

 <!--Code Dx URL-->
<div class="setting-section">
    <div class="setting-textfield">
        [@ww.textfield label="Code Dx API URL" name="url" onkeyup="serverCredentialsOnChange()" required='true'/]
    </div>
    <span id="help-button-codedx-url" class="setting-help-textfield" onclick="toggleHelp(this)">
        <i class="fas fa-question-circle"></i>
    </span>
</div>
<div id="help-content-codedx-url" class="setting-content">
    <span>The format is as follows: https://&lt;host&gt;:&lt;port&gt;/&lt;webapp_path&gt;/</span>
    <br/>
    <span>Overrides the default set in the plugin admin page.</span>
</div>
<div id="url-warning" style="color:#C4A000;">
	<i class="fas fa-exclamation-triangle"></i>
	<span>HTTP is considered insecure.  It is recommended that you use HTTPS.</span>
</div>

<!--Code Dx API Key-->
<div class="setting-section">
    <div class="setting-textfield">
        [@ww.textfield label="Code Dx API key" name="apiKey" onkeyup="serverCredentialsOnChange()" required='true'/]
    </div>
    <span id="help-button-api-key" class="setting-help-textfield" onclick="toggleHelp(this)">
        <i class="fas fa-question-circle"></i>
    </span>
</div>
<div id="help-content-api-key" class="setting-content">
    <span>Verify that the API key you provide has the appropriate project permissions on the Code Dx admin page.</span>
    <br/>
    <span>Overrides the default set in the plugin admin page.</span>
</div>

<!--Self-Signed Certificate-->
<div class="setting-section">
    <div class="setting-textfield">
        [@ww.textfield label="Self-Signed Certificate Fingerprint" name="fingerprint" onkeyup="serverCredentialsOnChange()" required='false'/]
    </div>
    <span id="help-button-self-signed" class="setting-help-textfield" onclick="toggleHelp(this)">
        <i class="fas fa-question-circle"></i>
    </span>
</div>
<div id="help-content-self-signed" class="setting-content">
    <span>If you're using a self-signed certificate, provide its SHA1 Fingerprint here.</span>
    <br/>
    <span>Overrides the default set in the plugin admin page.</span>
</div>

<h2>Task Run Settings</h2>

<!--Selected Project-->
<div class="setting-section">
	<div class="setting-textfield">
		[@ww.select label="Code Dx Project" name="selectedProjectId" list="projectList" listKey="id" listValue="name" required="true"/]
        <div id="reachabilityMessage" style="color:#F00000;">${reachabilityMessage}</div>
	</div>
	<span class="setting-button" onclick="refreshProjects()">Refresh Projects</span>
</div>

<!--Analysis Name-->
<div class="setting-section">
	<div class="setting-textfield">
		[@ww.textfield label="Analysis Name" name="analysisName" required="true"/]
	</div>
	<span id="help-button-analysis-name" class="setting-help-textfield" onclick="toggleHelp(this)">
		<i class="fas fa-question-circle"></i>
	</span>
</div>
<div id="help-content-analysis-name" class="setting-content">
    <p>
        This field lets you set a "name" for each Code Dx analysis published from Bamboo.
        Analysis names are mainly used to identify the bars in the "First Seen" and "Last Modified" filters on Code Dx's Findings page.
    </p>
    <p>
        You can use build/environment variables to construct a different name for each analysis. For example:
        </p><pre><code>${r"Build #${bamboo.buildNumber}"}</code></pre>
        would create the name `Build #26` for the 26th build of the project.
    <p></p>
    <p>
        For information on what environment variables are available, see
        <a href="https://confluence.atlassian.com/bamboo/bamboo-variables-289277087.html" target="_blank">Bamboo variables</a>.
    <p></p>
    <p>
        Note: the analysis name feature is only supported by Code Dx versions 2.4.0 and up. If the server you plan
        to publish to is older than version 2.4.0, the analysis name will be ignored.
    </p>
</div>

<!--Include Paths-->
<div class="setting-section">
	<div class="setting-textfield">
		[@ww.textfield label="Source and Binary Files" name="includePaths" required="true"/]
	</div>
	<span id="help-button-include-paths" class="setting-help-textfield" onclick="toggleHelp(this)">
    	<i class="fas fa-question-circle"></i>
    </span>
</div>
<div id="help-content-include-paths" class="setting-content">
    <span>This is a comma separated list of Ant-style GLOB paths (relative to workspace root) of source or binary files.</span>
    <span>Ex: src/main/java/**/*.java or bin/**/*.class.</span>
    <span>Any files matching the supplied paths will be included in the zip sent to Code Dx.</span>
    <span>For some information about the Ant GLOB format look <a href="https://ant.apache.org/manual/dirtasks.html">here</a>.</span>
</div>

<!--Exclude Paths-->
<div class="setting-section">
	<div class="setting-textfield">
		[@ww.textfield label="Excluded Source and Binary Files" name="excludePaths"/]
	</div>
	<span id="help-button-exclude-paths" class="setting-help-textfield" onclick="toggleHelp(this)">
		<i class="fas fa-question-circle"></i>
    </span>
</div>
<div id="help-content-exclude-paths" class="setting-content">
	<span>This is a comma separated list of Ant-style GLOB paths (relative to workspace root) of source or binary files.</span>
    <span>Ex: src/main/java/**/*.java or bin/**/*.class.</span>
    <span>Any files matching the supplied paths will be included in the zip sent to Code Dx.</span>
    <span>For some information about the Ant GLOB format look <a href="https://ant.apache.org/manual/dirtasks.html">here</a>.</span>
</div>

<!--Tool Output Files-->
<div class="setting-section">
	<div class="setting-textfield">
		[@ww.textfield label="Tool Output Files" name="toolOutputFiles"/]
	</div>
	<span id="help-button-tool-output" class="setting-help-textfield" onclick="toggleHelp(this)">
        <i class="fas fa-question-circle"></i>
    </span>
</div>
<div id="help-content-tool-output" class="setting-content">
	<span>This is a comma separated list of tool output file paths (relative to workspace root).</span>
    <span>Consult the Code Dx documentation for a list of supported output file formats for your edition.</span>
</div>

<!--Wait For Results-->
<div class="setting-section">
	<div class="setting-checkbox">
		[@ww.checkbox id="waitForResultsCheckbox" label="Wait for Analysis Results" name="waitForResults" onclick="updateWaitForResultsAdvanced()"/]
	</div>
	<span id="help-button-wait-results" class="setting-help-checkbox" onclick="toggleHelp(this)">
        <i class="fas fa-question-circle"></i>
    </span>
</div>
<div id="help-content-wait-results" class="setting-content">
    <span>When checked, Bamboo will wait for the results of the Code Dx analysis before the build completes.</span>
    <span>This will allow for the retrieval of results from Code Dx.</span>
</div>

<!--Section opens when "Wait for Analysis Results" is checked"-->
<div id="waitForResultsAdvanced">

	<!--Build Failure Severity-->
    <div class="setting-section">
    	<div class="setting-textfield">
    		[@ww.select label="Build Failure Severity" id="failureSeverity" name="selectedFailureSeverity" list="severities" listKey="name" listValue="displayName"/]
    	</div>
    	<span id="help-button-build-failure" class="setting-help-textfield" onclick="toggleHelp(this)">
            <i class="fas fa-question-circle"></i>
        </span>
    </div>
    <div id="help-content-build-failure" class="setting-content">
    	<span>The build will be considered a failure if one or more findings are detected with the selected severity range.</span>
    </div>

	<!--Only Consider New Findings-->
    <div class="setting-section">
    	<div class="setting-checkbox">
    		[@ww.checkbox label="Only Consider New Findings" name="onlyConsiderNewFindings"/]
    	</div>
    	<span id="help-button-only-new" class="setting-help-checkbox" onclick="toggleHelp(this)">
            <i class="fas fa-question-circle"></i>
        </span>
    </div>
    <div id="help-content-only-new" class="setting-content">
        <span>Only findings with the 'New' status will be considered when determining if the build is a failure.</span>
    </div>

</div>

<!-- Workaround for bug(?) in bamboo to pass variables from server.  After failing to save a configuration, variables get passed down inside of a size 1 array.  This causes normal escape syntax to fail. -->
<!-- Pass the variables the user can edit through hidden fields instead -->
<div style="display:none;">
	[@ww.textfield label="" id="passVarUseDefaults" name="useDefaults" required="false"/]
	[@ww.textfield label="" id="passVarDefaultsSet" name="defaultsSet" required="false"/]
	[@ww.textfield label="" id="passVarFailedSave" name="failedSave" required="false"/]
</div>

<script>

	// String "startsWith" polyfill for IE
	if (!String.prototype.startsWith) {
        Object.defineProperty(String.prototype, 'startsWith', {
            value: function(search, pos) {
                return this.substring(!pos || pos < 0 ? 0 : +pos, pos + search.length) === search;
            }
        });
    }

	// Workaround for bug(?) in bamboo to pass variables from server.  After failing to save a configuration, variables get passed down inside of a size 1 array.  This causes normal escape syntax to fail.
	// Get these from hidden fields instead.
	var defaultsSet = (document.getElementById("passVarDefaultsSet").value == "true");
	var failedSave = (document.getElementById("passVarFailedSave").value == "true"); // Not currently used

	var useDefaults = document.getElementById("useDefaultCheckbox").checked;

	// The user can't edit these variables so we can use normal escape syntax.
	var defaultUrl = "${defaultUrl}";
	var defaultApiKey = "${defaultApiKey}";
	var defaultFingerprint = "${defaultFingerprint}";

	var savedUrl = document.getElementById("url").value;
	var savedApiKey = document.getElementById("apiKey").value;
	var savedFingerprint = document.getElementById("fingerprint").value;

	var refreshProjectsUrl = document.getElementById("url").value;
    var refreshProjectsApiKey = document.getElementById("apiKey").value;
    var refreshProjectsFingerprint = document.getElementById("fingerprint").value;

	// Update when the page is loaded
	onPageLoad();

    function onPageLoad() {

	    updateWaitForResultsAdvanced();
	    updateUrlWarning();

		if (defaultsSet) {
	        if (useDefaults) {
	            // Disable the fields
	            document.getElementById("url").disabled = true;
	            document.getElementById("apiKey").disabled = true;
	            document.getElementById("fingerprint").disabled = true;
	        }
	    } else {
	        document.getElementById("useAdminDefaultSection").style.display = "none";
	    }

		if (document.getElementById("selectedProjectId").children.length == 0) {
			document.getElementById("selectedProjectId").disabled = true;
		}
    }

    function updateWaitForResultsAdvanced() {
        var checkbox = document.getElementById("waitForResultsCheckbox");
        var advanced = document.getElementById("waitForResultsAdvanced");
        advanced.style.display = checkbox.checked ? "block" : "none";
    }

    function toggleUseDefaults() {

        var checked = document.getElementById("useDefaultCheckbox").checked;

        document.getElementById("passVarUseDefaults").value = (checked ? "true" : "false");

        if (checked) {
            document.getElementById("useDefaultCheckbox").value = "true";
        } else {
            document.getElementById("useDefaultCheckbox").value = "false";
        }

        var urlField = document.getElementById("url");
        var apiKeyField = document.getElementById("apiKey");
        var fingerprintField = document.getElementById("fingerprint");

        if (checked) {

            // Save what they had for later in case they change their mind and uncheck.
            savedUrl = urlField.value;
            savedApiKey = apiKeyField.value;
            savedFingerprint = fingerprintField.value;

            // Set the fields to defaults
            urlField.value = defaultUrl;
            apiKeyField.value = defaultApiKey;
            fingerprintField.value = defaultFingerprint;

            // Disable the fields
            urlField.disabled = true;
            apiKeyField.disabled = true;
            fingerprintField.disabled = true;
        } else {

            // Set the fields back to what they were (likely empty)
            urlField.value = savedUrl;
            apiKeyField.value = savedApiKey;
            fingerprintField.value = savedFingerprint;

            // Enable the fields
            urlField.disabled = false;
            apiKeyField.disabled = false;
            fingerprintField.disabled = false;
        }

        // Warn the user http is insecure if they are using that
        updateUrlWarning();

        // Warn the user if they should refresh the projects
        serverCredentialsOnChange();
    }

	function toggleHelp(event) {
		var buttonId = event.id;
		var prefix = "help-button-";
		if (buttonId.startsWith(prefix)) {
			var suffix = buttonId.substring(prefix.length, buttonId.length);
			var content = document.getElementById("help-content-" + suffix);
			if (content) {
				var visible = content.style.display == "block";
				content.style.display = visible ? "none" : "block";
			}
		}
	}

	function refreshProjects() {

		var data = {
			url: document.getElementById("url").value,
            apiKey: document.getElementById("apiKey").value,
            fingerprint: document.getElementById("fingerprint").value
		};

		AJS.$.ajax({
            url:"${req.contextPath}/plugins/servlet/projectRefresherServlet",
            data: JSON.stringify(data),
            contentType: 'application/json',
            cache:false,
            type: 'POST',
            success:function (json) {

                var projects = JSON.parse(json).projects;

                var projectSelect = document.getElementById("selectedProjectId");
				var oldSelectedIndex = projectSelect.selectedIndex;

                // Remove old options
                while (projectSelect.options.length > 0) {
                    projectSelect.options.remove(0);
                }

                // Add new options
				for (var i = 0; i < projects.length; i++) {
					var option = document.createElement("option");
                    option.value = projects[i].id;
                    option.text = projects[i].name;
                    projectSelect.add(option);
				}

				// Try to keep the project they had selected, selected
				if (oldSelectedIndex >= 0 && projectSelect.options.length > oldSelectedIndex) {
					projectSelect.selectedIndex = oldSelectedIndex;
				}

				if (projects.length > 0) {
					updateReachabilityMessage("Projects refreshed successfully", false);
					projectSelect.disabled = false;
				} else {
					updateReachabilityMessage("No projects available for this API token", true);
					projectSelect.disabled = true;
				}
            },
            error:function (XMLHttpRequest, textStatus, errorThrown) {

				// Remove old options
				var projectSelect = document.getElementById("selectedProjectId");
				while (projectSelect.options.length > 0) {
					projectSelect.options.remove(0);
				}
				projectSelect.disabled = true;

                updateReachabilityMessage(XMLHttpRequest.responseText);
            }
        });

        // Update these values so we can properly warn the user if they need to refresh the projects again
        refreshProjectsUrl = document.getElementById("url").value;
        refreshProjectsApiKey = document.getElementById("apiKey").value;
        refreshProjectsFingerprint = document.getElementById("fingerprint").value;
	}

	function serverCredentialsOnChange() {
		let url = document.getElementById("url").value;
        let apiKey = document.getElementById("apiKey").value;
        let fingerprint = document.getElementById("fingerprint").value;

        if (url != refreshProjectsUrl || apiKey != refreshProjectsApiKey || fingerprint != refreshProjectsFingerprint) {
            // Warn the user if they should refresh the projects
            updateReachabilityMessage("Code Dx server info changed.  It is recommended to refresh the project list.");
        } else {
            updateReachabilityMessage(); // Remove warning
        }

		// Warn the user http is insecure if they are using that
		updateUrlWarning();
	}

	function updateUrlWarning() {
        var urlWarning = document.getElementById("url-warning");
        var isHttp = document.getElementById("url").value.startsWith("http:");
        urlWarning.style.display = isHttp ? "block" : "none";
	}

	function updateReachabilityMessage(message, error) {

		if (error === undefined) {
			error = true; // IE doesn't support default values for function parameter (ES6)
		}

		if (!message) {
			message = "";
		}
		var messageDiv = document.getElementById("reachabilityMessage");
		messageDiv.innerHTML = message;
		messageDiv.style.display = (message === "") ? "none" : "block";
		messageDiv.style.color = error ? "#F00000" : "#00D000";
	}

</script>
