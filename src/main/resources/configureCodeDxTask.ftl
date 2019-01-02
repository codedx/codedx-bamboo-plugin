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
        color: #205081BB;
        font-size: 1.25rem;
        cursor: pointer;
        padding: 5px;
        align-self: flex-end;
    }

    .setting-help-checkbox {
        color: #205081BB;
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

    code {
        width: fit-content;
        padding-right: 15px;
    }

</style>

<!--Selected Project-->
<div class="setting-section">
	<div class="setting-textfield">
		[@ww.select label="Code Dx Project" name="selectedProjectId" list="projectList" listKey="id" listValue="name" required="true"/]
        <div style="color:#F00000;">
            ${reachabilityMessage}
        </div>
	</div>
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
<div id="waitForResultsAdvanced"">

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

	<!--Report Archive Name-->
    <div class="setting-section">
        <div class="setting-textfield">
            [@ww.textfield label="Report Archive Name" name="reportArchiveName"/]
        </div>
        <span id="help-button-report-name" class="setting-help-textfield" onclick="toggleHelp(this)">
            <i class="fas fa-question-circle"></i>
        </span>
    </div>
    <div id="help-content-report-name" class="setting-content">
        <span>Please provide a unique name for the report archive file.</span>
        <span>If the name is not unique, the report may be overwritten by other Code Dx build steps.</span>
    </div>

</div>

<script>

	// Update when the page is loaded
	updateWaitForResultsAdvanced();

	function updateWaitForResultsAdvanced() {
		var checkbox = document.getElementById("waitForResultsCheckbox");
		var advanced = document.getElementById("waitForResultsAdvanced");
		advanced.style.display = checkbox.checked ? "block" : "none";
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

</script>
