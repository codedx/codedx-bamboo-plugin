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

[@ww.submit value="Update Projects" name="submitName" theme='simple'/]

[@ww.textfield
	label="Code DX Analysis Name"
	name="analysisName"
	required='true'
/]