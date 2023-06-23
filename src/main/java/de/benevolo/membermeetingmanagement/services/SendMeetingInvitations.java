package de.benevolo.membermeetingmanagement.services;

import de.benevolo.membermeetingmanagement.entities.Membermeeting;

import de.benevolo.MailService;
import de.benevolo.email.Email;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SendMeetingInvitations {

    private Membermeeting membermeeting;
    private List<String> memberList;
    
    private MailService mailService = MailService.getInstance();

    private String html = String.format("""
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
                <p>hiermit laden wir dich herzlich zur Mitgliederversammlung ein.</p>
                <p>Deine Teilnahme und Mitarbeit sind für uns von großer Bedeutung, um gemeinsam die Zukunft unseres Vereins zu gestalten. </p>
                <p>Hier sind die Details zur Versammlung:</p>
                <p>Datum: %d</p>
                <p>Ort: %s</p>
                <p>Tagesordnung:</p>
                <p>%s</p>
                <p>Wir freuen uns auf deine Teilnahme und dein Engagement bei der Mitgliederversammlung. Gemeinsam können wir unseren Verein weiter voranbringen und unsere Ziele erreichen. </p>
                <p>Freundliche Grüße,</p>
                <p>Ihr Vorstand</p>
                </div>
            </body>
        </html>
        """, membermeeting.getDate(), membermeeting.getLocation(), membermeeting.getAgenda());

    public void sentEmail() {

        Email email = new Email("chh3020@thi.de","Christian","Einladung zur Mitgliederversammlung",html,"jav4296@thi.de","Jan");

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
