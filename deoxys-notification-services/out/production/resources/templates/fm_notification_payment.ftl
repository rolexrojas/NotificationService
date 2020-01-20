<!-- THIS EMAIL WAS BUILT AND TESTED WITH LITMUS http://litmus.com -->
<!-- IT WAS RELEASED UNDER THE MIT LICENSE https://opensource.org/licenses/MIT -->
<!-- QUESTIONS? TWEET US @LITMUSAPP -->
<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <style type="text/css">
        /* FONTS */
        @media screen {
            @font-face {
                font-family: 'Gotham Book';
                font-style: normal;
                font-weight: normal;
                src: local('Gotham Book'), url('https://res.cloudinary.com/gcs-systems/raw/upload/v1560365828/GothamBook_hmvv30.woff') format('woff');
            }

            @font-face {
                font-family: 'Gotham Light';
                font-style: normal;
                font-weight: normal;
                src: local('Gotham Light'), url('https://res.cloudinary.com/gcs-systems/raw/upload/v1560365828/GothamLight_bmmpuk.woff') format('woff');
            }

            @font-face {
                font-family: 'Gotham Bold';
                font-style: normal;
                font-weight: normal;
                src: local('Gotham Bold'), url('https://res.cloudinary.com/gcs-systems/raw/upload/v1560365828/GothamBold_fh9spa.woff') format('woff');
            }

        }

        /* CLIENT-SPECIFIC STYLES */
        body, table, td, a { -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; }
        table, td { mso-table-lspace: 0pt; mso-table-rspace: 0pt; }
        img { -ms-interpolation-mode: bicubic; }

        /* RESET STYLES */
        img { border: 0; height: auto; line-height: 100%; outline: none; text-decoration: none; }
        table { border-collapse: collapse !important; }
        body { height: 100% !important; margin: 0 !important; padding: 0 !important; width: 100% !important; }

        /* iOS BLUE LINKS */
        a[x-apple-data-detectors] {
            color: inherit !important;
            text-decoration: none !important;
            font-size: inherit !important;
            font-family: inherit !important;
            font-weight: inherit !important;
            line-height: inherit !important;
        }

        /* MOBILE STYLES */
        @media screen and (max-width:600px){
            h1 {
                font-size: 32px !important;
                line-height: 32px !important;
            }
        }

        /* ANDROID CENTER FIX */
        div[style*="margin: 16px 0;"] { margin: 0 !important; }
    </style>
</head>
<body style="background-color: #f4f4f4; margin: 0 !important; padding: 0 !important;">


<table border="0" cellpadding="0" cellspacing="0" width="100%">
    <!-- LOGO -->
    <tr>
        <td bgcolor="#9F1B96" align="center">
            <!--[if (gte mso 9)|(IE)]>
            <table align="center" border="0" cellspacing="0" cellpadding="0" width="600">
                <tr>
                    <td align="center" valign="top" width="600">
            <![endif]-->
            <table border="0" cellpadding="0" cellspacing="0" width="100%" style="max-width: 600px;" >
                <tr>
                    <td align="center" valign="top" style="padding: 40px 10px 40px 10px;">

                        <img alt="Logo" src="http://res.cloudinary.com/imagenesgcs/image/upload/v1503434077/01_LOGOTIPO_tPago-01_bo1fv3.png" width="40" height="40" style="display: block; width: 170px; max-width: 170px; min-width: 40px; font-family: 'Gotham Book', Helvetica, Arial, sans-serif; color: #ffffff; font-size: 18px;" border="0">

                    </td>
                </tr>
            </table>
            <!--[if (gte mso 9)|(IE)]>
            </td>
            </tr>
            </table>
            <![endif]-->
        </td>
    </tr>
    <!-- HERO -->
    <tr>
        <td bgcolor="#9F1B96" align="center" style="padding: 0px 10px 0px 10px;">
            <!--[if (gte mso 9)|(IE)]>
            <table align="center" border="0" cellspacing="0" cellpadding="0" width="600">
                <tr>
                    <td align="center" valign="top" width="600">
            <![endif]-->
            <table border="0" cellpadding="0" cellspacing="0" width="100%" style="max-width: 600px;" >
                <tr>
                    <td bgcolor="#ffffff" align="center" valign="top" style="padding: 40px 20px 20px 20px; border-radius: 4px 4px 0px 0px; color: #666666; font-family: 'Gotham Bold', Helvetica, Arial, sans-serif; font-size: 48px; font-weight: 400;  line-height: 48px;">
                        <img alt="Logo" src="https://res.cloudinary.com/gcs-systems/image/upload/v1560365171/verified_w6si48.png" width="50" height="50" >
                        <h1 style="font-size: 32px; font-weight: 400; margin: 0;">Notificación de pago</h1>
                    </td>
                </tr>
            </table>
            <!--[if (gte mso 9)|(IE)]>
            </td>
            </tr>
            </table>
            <![endif]-->
        </td>
    </tr>
    <!-- COPY BLOCK -->
    <tr>
        <td bgcolor="#f4f4f4" align="center" style="padding: 0px 10px 0px 10px;">

            <table border="0" cellpadding="0" cellspacing="0" width="100%" style="max-width: 600px;" >
                <!-- COPY -->
                <tr>
                    <td bgcolor="#ffffff" align="left" style="padding: 20px 30px 20px 30px; color: #666666; font-family: 'Gotham Book', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;" >
                        <p style="margin: 0;">Estimado (a) <b>${merchantDescription}</b> </p><br>
                        <p style="margin: 0;">Usted ha recibido un pago de <b>${currency}${transactionAmount} </b>
                        <p style="margin: 0;">a su cuenta terminada en <b>${destinationAccountNumber}.</b>
                    </td>
                </tr>

                <!-- COPY -->
                <tr>
                    <td bgcolor="#ffffff" align="left" style="padding: 0px 30px 20px 30px; color: #666666; font-family: 'Gotham Book', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;" >
                        <p style="margin: 0;">Desde: <br><b>${sourceAccountNumber}</b> &nbsp;&nbsp; <br><b>Teléfono: &nbsp; ${sourceAccountName}.</b>
                    </td>
                </tr>

                <!-- COPY -->
                <tr>
                    <td bgcolor="#ffffff" align="left" style="padding: 0px 30px 20px 30px; color: #666666; font-family: 'Gotham Book', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;" >
                        <p style="margin: 0;">Fecha: <b>${transactionDate}</b>
                    </td>
                </tr>

                <!-- COPY -->
                <tr>
                    <td bgcolor="#ffffff" align="left" style="padding: 0px 30px 20px 30px; color: #666666; font-family: 'Gotham Book', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;" >
                        <p style="margin: 0;">No. de transacción: <b>${transactionNumber}</b>
                    </td>
                </tr>
                <!-- COPY -->
                <tr>
                    <td bgcolor="#ffffff" align="left" style="padding: 0px 30px 20px 30px; color: #666666; font-family: 'Gotham Book', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;" >
                        <p style="margin: 0;">Estamos comprometidos con entregarle una experiencia memorable de servicio.</p>
                    </td>
                </tr>
                <!-- COPY -->
                <tr>
                    <td bgcolor="#ffffff" align="left" style="padding: 0px 30px 40px 30px; border-radius: 0px 0px 4px 4px; color: #666666; font-family: 'Gotham Book', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;" >
                        <p style="margin: 0;">Atentamente,<br>tPago<br></p>
                    </td>
                </tr>
                <tr>
                    <td bgcolor="#ffffff" align="left" style="padding: 0px 30px 40px 30px; border-radius: 0px 0px 4px 4px; color: #666666; font-family: 'Gotham Book', Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 25px;" >
                        <p style="margin: 0;">Contáctanos a:&nbsp;<b>info@tpago.com</b></p>
                    </td>
                </tr>
            </table>

        </td>
    </tr>
    <!-- SUPPORT CALLOUT -->

    <!-- FOOTER -->
    <tr>
        <td bgcolor="#f4f4f4" align="center" style="padding: 0px 10px 0px 10px;">
            <!--[if (gte mso 9)|(IE)]>
            <table align="center" border="0" cellspacing="0" cellpadding="0" width="600">
                <tr>
                    <td align="center" valign="top" width="600">
            <![endif]-->
            <table border="0" cellpadding="0" cellspacing="0" width="100%" style="max-width: 600px;" >
                <!-- NAVIGATION -->
                <tr>
                    </br>
                    </br>
                </tr>
                <!-- PERMISSION REMINDER
                <tr>
                    <td bgcolor="#f4f4f4" align="left" style="padding: 0px 30px 30px 30px; color: #666666; font-family: 'Gotham Book', Helvetica, Arial, sans-serif; font-size: 14px; font-weight: 400; line-height: 18px;" >
                        <p style="margin: 0;">Recibiste este correo porque acabas de crear una cuenta en la aplicación <strong>tPago</strong> </p>
                    </td>
                </tr> -->


            </table>
            <!--[if (gte mso 9)|(IE)]>
            </td>
            </tr>
            </table>
            <![endif]-->
        </td>
    </tr>
</table>

<!-- LITMUS ATTRIBUTION -->
<table border="0" cellpadding="0" cellspacing="0" width="100%">
    <tr>
        <td bgcolor="#ffffff" align="center">
            <!--[if (gte mso 9)|(IE)]>
            <table align="center" border="0" cellspacing="0" cellpadding="0" width="600">
                <tr>
                    <td align="center" valign="top" width="600">
            <![endif]-->
            <table border="0" cellpadding="0" cellspacing="0" width="100%" style="max-width: 600px;" >
                <tr>
                    <td bgcolor="#ffffff" align="center" style="padding: 30px 30px 30px 30px; color: #666666; font-family: Helvetica, Arial, sans-serif; font-size: 14px; font-weight: 400; line-height: 18px;" >
                        <p style="margin: 0;"> </p>
                    </td>
                </tr>
            </table>
            <!--[if (gte mso 9)|(IE)]>
            </td>
            </tr>
            </table>
            <![endif]-->
        </td>
    </tr>
</table>
<!-- END LITMUS ATTRIBUTION -->

</body>
</html>
