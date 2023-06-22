package de.benevolo.membermeetingmanagement.services;

// import de.thi.associationManagement.AssociationResource;

import de.benevolo.MailService;
import de.benevolo.email.Email;

import java.util.List;

public class SendMeetingInvitations {

    private List<String> memberList;
    
    private MailService mailService = MailService.getInstance();

    private String html = """
            <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Willkommens-E-Mail</title>
</head>
<body>
<div style="max-width: 600px; margin: 0 auto; padding: 20px;">
<h1>Willkommen bei Benevolo!</h1>
<p>Hallo <b> $username</b>!</p>
<p>Herzlich willkommen bei Benevolo! Wir freuen uns, dass du dich für unseren Service entschieden hast, um Vereine zu managen.</p>
<p>Als Mitglied unserer Plattform hast du Zugriff auf eine Vielzahl von Funktionen, die dir dabei helfen, den Verein effizient zu organisieren, Kommunikationen zu verwalten und Mitglieder einzubinden.</p>
<p>Unser Team steht dir jederzeit zur Verfügung, um dir bei Fragen oder Problemen behilflich zu sein. Zögere nicht, uns zu kontaktieren.</p>
<p>Wir wünschen dir viel Erfolg und Spaß bei der Nutzung von Benevolo!</p>
<p>Freundliche Grüße,</p>
<p>Das Benevolo-Team</p>
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
