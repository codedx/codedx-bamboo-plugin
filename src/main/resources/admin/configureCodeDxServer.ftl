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

    [@ui.bambooSection]
        [@ww.hidden name='serverId'/]
        [@ww.textfield label="Code DX API URL" name="url" required='true'/]
        [@ww.textfield label="Code DX API key" name="apiKey" required='true'/]
    [/@ui.bambooSection]
[/@ww.form]
</body>
