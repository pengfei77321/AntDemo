<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Untitled Document</title>
        <script language="javascript">
            function checkname(){
                var div = document.getElementById("div1");
                div.innerHTML = "";
                var name1 = document.form1.text1.value;
                if (name1 == "") {
                    div.innerHTML = "��������Ϊ�գ�";
                    document.form1.text1.focus();
                    return false;
                }
                if (name1.length < 4 || name1.length > 16) {
                    div.innerHTML = "��������ĳ���4-16���ַ���";
                    document.form1.text1.select();
                    return false;
                }
                var charname1 = name1.toLowerCase();
                for (var i = 0; i < name1.length; i++) {
                    var charname = charname1.charAt(i);
                    if (!(charname >= 0 && charname <= 9) && (!(charname >= 'a' && charname <= 'z')) && (charname != '_')) {
                        div.innerHTML = "���������Ƿ���ĸ��ֻ�ܰ�����ĸ�����֣����»���";
                        document.form1.text1.select();
                        return false;
                    }
                }
                return true;

            }

            function checkpassword(){
                var div = document.getElementById("div2");
                div.innerHTML = "";
                var password = document.form1.text2.value;
                if (password == "") {
                    div.innerHTML = "���벻λ�գ�";
                    document.form1.text2.focus();
                    return false;
                }
                if (password.length < 4 || password.length > 12) {
                    div.innerHTML = "���볤��4-12λ";
                    document.form1.text2.select();
                    return false;
                }
                return true;
            }

            function checkrepassword(){
                var div = document.getElementById("div3");
                div.innerHTML = "";
                var password = document.form1.text2.value;
                var repass = document.form1.text3.value;
                if (repass == "") {
                    div.innerHTML = "���벻λ�գ�";
                    document.form1.text3.focus();
                    return false;
                }
                if (password != repass) {
                    div.innerHTML = "���������ȷ�����볤�Ȳ�һ��";
                    document.form1.text3.select();
                    return false;
                }
                return true;
            }

            function checkEmail(){
                var div = document.getElementById("div4");
                div.innerHTML = "";
                var email = document.form1.text5.value;
                var sw = email.indexOf("@", 0);
                var sw1 = email.indexOf(".", 0);
                var tt = sw1 - sw;
                if (email.length == 0) {
                    div.innerHTML = "�����ʼ�����λ��";
                    document.form1.text5.focus();
                    return false;
                }
                if (email.indexOf("@", 0) == -1) {
                    div.innerHTML = "�����ʼ���ʽ����ȷ���������@���ţ�";
                    document.form1.text5.select();
                    return false;
                }
                if (email.indexOf(".", 0) == -1) {
                    div.innerHTML = "�����ʼ���ʽ����ȷ���������.���ţ�";
                    document.form1.text5.select();
                    return false;
                }
                if (tt == 1) {
                    div.innerHTML = "�ʼ���ʽ���ԡ�@��.�����԰��ţ�";
                    document.form1.text5.select();
                    return false;
                }
                if (sw > sw1) {
                    div.innerHTML = "�����ʼ���ʽ����ȷ��@���ű�����.֮ǰ";
                    document.form1.text5.select();
                    return false;
                }
                else {
                    return true;
                }

                return ture;
            }

            function check(){
                if (checkname() && checkpassword() && checkrepassword() && checkEmail()) {
                    return true;
                }
                else {
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <form name="form1" method="post" action="2.html" onsubmit="return check()">
            <table>
                <tr>
                    <td>
                        �û�����
                    </td>
                    <td>
                        <input id="text1" type="text" name="text1" onblur="check()">
                        <div id="div1" style="display:inline">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        ���룺
                    </td>
                    <td>
                        <input id="text2" type="password" name="text2" onblur="check()">
                        <div id="div2" style="display:inline">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        ȷ�����룺
                    </td>
                    <td>
                        <input id="text3" type="password" name="text3" onblur="check()">
                        <div id="div3" style="display:inline">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        �����ʼ���ַ��
                    </td>
                    <td>
                        <input id="text4" type="text" name="text4" onblur="check()">
                        <div id="div4" style="display:inline">
                        </div>
                    </td>
                </tr>
                <tr align="center">
                    <td align="center">
                        <input type="submit" value="�ύ" name="tect6"><input type="reset" value="����" name="text7">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>