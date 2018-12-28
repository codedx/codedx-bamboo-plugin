[@ww.select
	label="Code Dx Project"
	id="project"
    name="selectedProjectId"
    value="selectedProjectId"
    list="projectList"
    listKey="id"
    listValue="name"
	required="true"
	toggle="true"
/]
<div style="color:#F00000;">
	${reachabilityMessage}
</div>

[@ww.textfield
	label="Code Dx Analysis Name"
	name="analysisName"
	required="true"
/]

[@ww.textfield
	label="Source and binaries"
	name="includePaths"
	required="true"
/]

[@ww.textfield
	label="Files to exclude"
	name="excludePaths"
	required="false"
/]

[@ww.textfield
	label="Tool output files"
	name="toolOutputFiles"
	required="false"
/]

[@ww.checkbox
	id="waitForResultsCheckbox"
	label="Wait for analysis results"
	name="waitForResults"
	required="false"
	onclick="updateWaitForResultsAdvanced()"
/]

<div id="waitForResultsAdvanced"">
	[@ww.select
    	label="Build Failure Severity"
    	id="failureSeverity"
        name="selectedFailureSeverity"
        value="selectedFailureSeverity"
        list="severities"
        listKey="name"
        listValue="displayName"
    	required="false"
    	toggle="true"
    /]

    [@ww.checkbox
    	label="Only consider new findings"
    	name="onlyConsiderNewFindings"
    	required="false"
    /]

    [@ww.textfield
    	label="Report archive name"
    	name="reportArchiveName"
    	required="false"
    /]
</div>

<script>

	// Update when the page is loaded
	updateWaitForResultsAdvanced();

	function updateWaitForResultsAdvanced() {
		var checkbox = document.getElementById("waitForResultsCheckbox");
		var advanced = document.getElementById("waitForResultsAdvanced");
		advanced.style.display = checkbox.checked ? "block" : "none";
	}
</script>
