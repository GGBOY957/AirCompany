// document.write("<script language='javascript' src='/js/x-layui.js'></script>")


// function userLook(title, url, id, w, h) {
//     x_admin_show(title, url, w, h);
// }


function getRowObj(obj) {
    var i = 0;
    while (obj.tagName.toLowerCase() != "tr") {
        obj = obj.parentNode;
        if (obj.tagName.toLowerCase() == "table") return null;
    }
    return obj;
}

//删除行
function userDelete(obj) {
    var txt;
    var tr = this.getRowObj(obj);
    if (confirm("确认删除？")) {
        if (tr != null) {
            tr.parentNode.removeChild(tr);
            alert("删除成功！")
            txt = true;
        } else {
            throw new Error("the given object is not contained by the table");
        }
    } else {
        txt = false;
    }
}
