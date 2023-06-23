package de.benevolo.membermeetingmanagement.services;

// import de.thi.associationManagement.AssociationResource;

import de.benevolo.MailService;
import de.benevolo.email.Email;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SendMeetingInvitations {

    private List<String> memberList;
    
    private MailService mailService = MailService.getInstance();

    private String html = """
            <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Anstehende Mitgliederversammlung</title>
</head>
<body>
<div style="max-width: 600px; margin: 0 auto; padding: 20px;">
<h1>Einladung zur Mitgliederversammlung!</h1>
<p>Liebes Vereinsmitglied,</p>
<p>hiermit laden wir dich herzlich zur Mitgliederversammlung des [Vereinsname] ein.</p>
<p>Deine Teilnahme und Mitarbeit sind für uns von großer Bedeutung, um gemeinsam die Zukunft unseres Vereins zu gestalten. </p>
<p>Hier sind die Details zur Versammlung:</p>
<p>Datum: [Datum der Versammlung]</p>
<p>Uhrzeit: [Uhrzeit der Versammlung]</p>
<p>Ort: [Veranstaltungsort]</p>
<p>Tagesordnung:</p>
<p>[Agenda]</p>
<p>Wir freuen uns auf deine Teilnahme und dein Engagement bei der Mitgliederversammlung. Gemeinsam können wir unseren Verein weiter voranbringen und unsere Ziele erreichen. </p>
<p>Freundliche Grüße,</p>
<p>[Vorstand]</p>
</div>
</body>
</html>
            """;

    public void sentEmail() {

        Email email = new Email("chh3020@thi.de","Christian","Testmail",html,"jav4296@thi.de","Jan");

        try {
        mailService.sendMessage(email);
        }
        catch (Exception e) {

        }
    }





    public List<String> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<String> memberList) {
        this.memberList = memberList;
    }
}
