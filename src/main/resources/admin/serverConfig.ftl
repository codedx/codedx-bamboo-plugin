<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Code Dx Plugin Configuration</title>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
        integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
        crossorigin="anonymous"/>
  <style>
    body { font-family: Arial, sans-serif; margin: 20px; }
    h1 { font-size: 1.5em; margin-bottom: 20px; }
    .field-group { margin-bottom: 15px; }
    label { display: block; font-weight: bold; margin-bottom: 4px; }
    input[type=text] { width: 400px; padding: 5px; font-size: 1em; }
    .setting-section { display: flex; padding: 5px 0; align-items: flex-start; }
    .setting-help-textfield { opacity: 0.75; color: #205081; font-size: 1.25rem; cursor: pointer; padding: 5px; }
    .setting-content { display: none; border: 1px solid #CCC; border-radius: 3px; padding: 5px; background: #EEE; width: 90%; max-width: 740px; margin-top: 4px; }
    .buttons { margin-top: 20px; }
    input[type=submit] { padding: 6px 16px; font-size: 1em; cursor: pointer; }
  </style>
</head>
<body>
  <h1>Code Dx Plugin Configuration</h1>
  <form method="POST" action="">
    <input type="hidden" name="atl_token" value="${atl_token}"/>

    <div class="field-group">
      <label for="url">Default Code Dx API URL <span style="color:red">*</span></label>
      <div class="setting-section">
        <input type="text" id="url" name="url" value="${url}" required/>
        <span id="help-button-codedx-url" class="setting-help-textfield" onclick="toggleHelp(this)">
          <i class="fas fa-question-circle"></i>
        </span>
      </div>
      <div id="help-content-codedx-url" class="setting-content">
        <span>The format is as follows: https://&lt;host&gt;:&lt;port&gt;/&lt;webapp_path&gt;/</span><br/>
        <span>Can be overridden on Task Configuration page.</span>
      </div>
    </div>

    <div class="field-group">
      <label for="apiKey">Default Code Dx API key <span style="color:red">*</span></label>
      <div class="setting-section">
        <input type="text" id="apiKey" name="apiKey" value="${apiKey}" required/>
        <span id="help-button-api-key" class="setting-help-textfield" onclick="toggleHelp(this)">
          <i class="fas fa-question-circle"></i>
        </span>
      </div>
      <div id="help-content-api-key" class="setting-content">
        <span>Verify that the API key you provide has the appropriate project permissions on the Code Dx admin page.</span><br/>
        <span>Can be overridden on Task Configuration page.</span>
      </div>
    </div>

    <div class="field-group">
      <label for="fingerprint">Default Self-Signed Certificate Fingerprint</label>
      <div class="setting-section">
        <input type="text" id="fingerprint" name="fingerprint" value="${fingerprint}"/>
        <span id="help-button-self-signed" class="setting-help-textfield" onclick="toggleHelp(this)">
          <i class="fas fa-question-circle"></i>
        </span>
      </div>
      <div id="help-content-self-signed" class="setting-content">
        <span>If you're using a self-signed certificate, provide its SHA1 Fingerprint here.</span><br/>
        <span>Can be overridden on Task Configuration page.</span>
      </div>
    </div>

    <div class="buttons">
      <input type="submit" value="Update"/>
    </div>
  </form>

  <script>
    if (!String.prototype.startsWith) {
      Object.defineProperty(String.prototype, 'startsWith', {
        value: function(search, pos) {
          return this.substring(!pos || pos < 0 ? 0 : +pos, pos + search.length) === search;
        }
      });
    }
    function toggleHelp(event) {
      var buttonId = event.id;
      var prefix = 'help-button-';
      if (buttonId.startsWith(prefix)) {
        var suffix = buttonId.substring(prefix.length, buttonId.length);
        var content = document.getElementById('help-content-' + suffix);
        if (content) {
          var visible = content.style.display == 'block';
          content.style.display = visible ? 'none' : 'block';
        }
      }
    }
  </script>
</body>
</html>
