<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://www.osworks.cn/tag/aos" prefix="aos"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<aos:html>
<aos:head title="图标大全">
	<aos:include lib="ext" />
	<aos:base href="system/icon/" />
</aos:head>
<aos:body>
</aos:body>
<aos:onready>
	<aos:viewport layout="border">
		<aos:panel region="west" width="160" border="false">
			<aos:docked forceBoder="${bodyBorder}">
				<aos:dockeditem xtype="button" icon="icon140.png"/>
				<aos:dockeditem xtype="tbtext" text="图标分类导航"/>				
			</aos:docked>
			<aos:menu floating="false" border="false">
				<c:forEach var="page" items="${mdpm.subPages}">
					<c:if test="${page.type_ == '2' }">
						<aos:menuitem id="_id_${page.id_}" text="${page.name_}"
							onclick="_fn_load('${page.url_}&aos_module_id_=${page.module_id_}&aos_page_id_=${page.id_}')"
							icon="${page.icon_}" />
					</c:if>
					<c:if test="${page.type_ == '4' }">
						<aos:menuitem xtype="menuseparator" />
					</c:if>
				</c:forEach>
			</aos:menu>
		</aos:panel>
		<aos:panel region="center" layout="fit" bodyBorder="0 0 0 1">
			<aos:iframe id="_iframe" loadMask="正在努力加载页面, 请稍候..." src="${mdpm.defaultPage.url_}&aos_module_id_=${mdpm.defaultPage.module_id_}&aos_page_id_=${mdpm.defaultPage.id_}" />
		</aos:panel>
	</aos:viewport>
	<script type="text/javascript">
		function _fn_load(url) {
			if (!App.empty(url)) {
				_iframe.load(url);
			}
		}
	</script>
</aos:onready>
</aos:html>