[@ww.select
	label="Code DX Project"
	id="project"
    name="selectedProjectId"
    value="selectedProjectId"
    list="projectList"
    listKey="id"
    listValue="name"
	required="true"
	toggle="true"
/]

[@ww.textfield
	label="Code DX Analysis Name"
	name="analysisName"
	required='true'
/]

[@ww.textfield
	label="Source and binaries"
	name="includePaths"
	required='true'
/]

[@ww.textfield
	label="Files to exclude"
	name="excludePaths"
	required='true'
/]