[#assign cancelUri = '/admin/codeDxServerConfig.action' /]
[#assign targetAction = 'codeDxServerSave']

<div class="paddedClearer"></div>
[@ww.form action=targetAction
          titleKey='Server Details'
          descriptionKey=''
          submitLabelKey='global.buttons.update'
          cancelUri='/admin/codeDxServerConfig.action'
          showActionErrors='true'
]
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous"/>

    <style>
    	.setting-section {
    	    display: flex;
    	    padding: 5px 0px 5px 0px;
    	}

    	.setting-textfield {

    	}

    	.setting-help-textfield {
    	    color: #205081BB;
    	    font-size: 1.25rem;
    	    cursor: pointer;
    	    padding: 5px;
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
    </style>

    [@ui.bambooSection]
        [@ww.hidden name='serverId'/]

        <!--Code Dx URL-->
        <div class="setting-section">
        	<div class="setting-textfield">
        		[@ww.textfield label="Default Code Dx API URL" name="url" required='true'/]
        	</div>
        	<span id="help-button-codedx-url" class="setting-help-textfield" onclick="toggleHelp(this)">
            	<i class="fas fa-question-circle"></i>
            </span>
        </div>
        <div id="help-content-codedx-url" class="setting-content">
            <span>The format is as follows: https://&lt;host&gt;:&lt;port&gt;/&lt;webapp_path&gt;/</span>
            <span>Can be overridden on Task Configuration page.</span>
        </div>

        <!--Code Dx API Key-->
        <div class="setting-section">
            <div class="setting-textfield">
                [@ww.textfield label="Default Code Dx API key" name="apiKey" required='true'/]
            </div>
            <span id="help-button-api-key" class="setting-help-textfield" onclick="toggleHelp(this)">
                <i class="fas fa-question-circle"></i>
            </span>
        </div>
        <div id="help-content-api-key" class="setting-content">
            <span>Verify that the API key you provide has the appropriate project permissions on the Code Dx admin page.</span>
            <span>Can be overridden on Task Configuration page.</span>
        </div>

		<!--Self-Signed Certificate-->
        <div class="setting-section">
            <div class="setting-textfield">
                [@ww.textfield label="Default Self-Signed Certificate Fingerprint" name="fingerprint" required='false'/]
            </div>
            <span id="help-button-self-signed" class="setting-help-textfield" onclick="toggleHelp(this)">
                <i class="fas fa-question-circle"></i>
            </span>
        </div>
        <div id="help-content-self-signed" class="setting-content">
            <span>If you're using a self-signed certificate, provide its SHA1 Fingerprint here.</span>
            <span>Can be overridden on Task Configuration page.</span>
        </div>

    [/@ui.bambooSection]
[/@ww.form]

<script>
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
