<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Code Dx Plugin Configuration</title>
  <meta name="decorator" content="atl.admin">
  <meta name="adminActiveSection" content="system.admin/plugins">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
        integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
        crossorigin="anonymous"/>
  <style>
    .codedx-config-form { max-width: 800px; }
    .codedx-config-form .field-group { margin-bottom: 20px; }
    .codedx-config-form label { display: block; font-weight: bold; margin-bottom: 4px; }
    .codedx-config-form input[type=text] { width: 100%; max-width: 500px; padding: 6px 8px; font-size: 14px; border: 1px solid #ccc; border-radius: 3px; box-sizing: border-box; }
    .codedx-config-form .setting-section { display: flex; align-items: flex-start; gap: 8px; }
    .codedx-config-form .setting-help-textfield { opacity: 0.75; color: #205081; font-size: 1.25rem; cursor: pointer; padding: 5px; flex-shrink: 0; }
    .codedx-config-form .setting-content { display: none; border: 1px solid #CCC; border-radius: 3px; padding: 8px; background: #EEE; width: 90%; max-width: 500px; margin-top: 4px; font-size: 13px; }
    .codedx-config-form .buttons { margin-top: 24px; display: flex; gap: 10px; align-items: center; }
    .codedx-config-form .aui-button { padding: 6px 16px; font-size: 14px; cursor: pointer; }
    .codedx-success-banner { background: #dff0d8; border: 1px solid #3c763d; color: #3c763d; padding: 10px 16px; border-radius: 3px; margin-bottom: 20px; display: flex; align-items: center; gap: 8px; }
    .codedx-success-banner .close-btn { margin-left: auto; cursor: pointer; font-weight: bold; background: none; border: none; color: #3c763d; font-size: 16px; }
  </style>
</head>
<body>
  <h1>Code Dx Plugin Configuration</h1>

  ${savedBanner}

  <div class="codedx-config-form">
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
        <input type="submit" class="aui-button aui-button-primary" value="Update"/>
      </div>
    </form>
  </div>

  <script>
    function toggleHelp(event) {
      var buttonId = event.id;
      var prefix = 'help-button-';
      if (buttonId.indexOf(prefix) === 0) {
        var suffix = buttonId.substring(prefix.length);
        var content = document.getElementById('help-content-' + suffix);
        if (content) {
          var visible = content.style.display === 'block';
          content.style.display = visible ? 'none' : 'block';
        }
      }
    }
    // Auto-dismiss success banner after 5 seconds
    (function() {
      var banner = document.getElementById('codedx-saved-banner');
      if (banner) {
        setTimeout(function() { banner.style.display = 'none'; }, 5000);
      }
    })();
  </script>
</body>
</html>
