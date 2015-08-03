<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">    
    <title>Samford Migration Blocks</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="/css/bootstrap.min.css?t=<s:property value="time"/>" type="text/css" rel="stylesheet" />
    <link href="/css/styles.css?t=<s:property value="time"/>" type="text/css" rel="stylesheet" />

    <script type="text/javascript" src="/javascript/jquery-1.9.0.js"></script>
  </head>
  <body>
    <div class="mt-header">
      <div class="container">
        <h1 class="brand">Cascade Server <span>Samford Migration Blocks</span></h1>
      </div>
    </div>
    <div id="page" class="container">
      <div class="row">
        <div class="span12">
          <p class="lead">Please select the Content Types and file extensions.</p>

          <div id="actionError" class="alert alert-block alert-error hide">
            <h5>The following error(s) were encountered:</h5>
            <div><s:actionerror /></div>
          </div>

          <form action="/AssignContentType" method="POST" class="form-horizontal">
            <div class="control-group">
              <label class="control-label" for="dataDefinitionBlockExtensions">Data Definition Block Extensions</label>
              <div class="controls">
                <input class="span4" type="text" id="dataDefinitionBlockExtensions" name="dataDefinitionBlockExtensions" value="<s:property value="dataDefinitionBlockExtensions"/>" />
              </div>
            </div>
            <div id="content-type-mappings"></div>
            <div class="control-group">
              <div class="controls">
                <button type="button" class="btn" id="add-ct">Add Content Type</button>
              </div>
            </div>
            <button class="btn pull-left" onclick="window.location='/AssignRootLevelFolders';return false;">Previous</button>
            <button type="submit" name="submitButton" class="btn btn-primary pull-right">Save and Next</button>
          </form>
        </div>
      </div>
    </div>
    
    <div id="content-type-mapping-template" class="hide content-type-mapping">
      <div class="control-group">
        <div class="controls">
          <label>
            Cascade Content Type
            <select name="selectedContentTypes" class="span4 selectedContentType">
              <s:iterator value="contentTypes">
                <s:set var="value"><s:property /></s:set>
                <option value="<s:property value="#value" />"><s:property value="#value" /></option>
              </s:iterator>
            </select>
          </label>
        </div>
      </div>
      <div class="control-group">
        <div class="controls">
          <label>
            Consider only files whose XML content matches this XPath
            <input class="span4 dataDefinitionBlockXPath" type="text" name="dataDefinitionBlockXPaths" />
          </label>
        </div>
      </div>
      <div class="control-group">
        <div class="controls">
          <button type="button" class="btn btn-danger rm-ct">Remove</button>
        </div>
      </div>
    </div>
    
    <script type="text/javascript">
      $(function() {
        var actionError = $("#actionError");
        if (actionError.find('div').text() !== "") {
          actionError.removeClass('hide');
        }
        
        <s:iterator value="mappedContentTypes">
          addContentTypeMapping("<s:property value="contentTypeInformation.path" escapeJavaScript="true" escape="false"/>", "<s:property value="dataDefinitionBlockXPath" escapeJavaScript="true" escape="false"/>");
        </s:iterator>
        
        <s:if test="mappedContentTypes.size() == 0">
          addContentTypeMapping("", "");
        </s:if>
        
        $('#add-ct').click(function(){
          addContentTypeMapping("", "");
        })
        
        $(document).on('click', '.rm-ct', function(){
          $(this).parents('.content-type-mapping').remove();
        })
      });
      
      var addContentTypeMapping = function(contentTypePath, dataDefinitionBlockXPath) {
        var $ctMapping = $('#content-type-mapping-template').clone();
        $ctMapping.find('.selectedContentType').val(contentTypePath);
        $ctMapping.find('.dataDefinitionBlockXPath').val(dataDefinitionBlockXPath);
        $ctMapping.removeClass('hide');
        $ctMapping.attr('id', '');
        $ctMapping.appendTo('#content-type-mappings');
      }
    </script>
  </body>
</html>