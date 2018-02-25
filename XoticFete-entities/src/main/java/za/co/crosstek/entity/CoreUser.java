package za.co.crosstek.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import za.co.crosstek.anot.EntityAnotation;
import za.co.crosstek.anot.FieldAnotation;
import za.co.crosstek.enums.FieldExclusion;
import za.co.crosstek.enums.FieldType;

@Entity
@EntityAnotation(label = "Core User", icon = "fa fa-user")
public class CoreUser extends CoreEntity {

    @NotNull
    @Column(unique = true, nullable = false)
    @FieldAnotation(label = "Username")
    private String userName;

    @Column(unique = true)
    @FieldAnotation(label = "Email")
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*"
            + "@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
            flags = {Pattern.Flag.CASE_INSENSITIVE},
            message = "Invalid Email Address.")
    private String email;

    @FieldAnotation(label = "First Name")
    private String firstName;

    @FieldAnotation(label = "Last Name")
    private String lastName;

    @FieldAnotation(label = "Cell", type = FieldType.CELL)
    private String cell;

    @NotNull
    @Column(length = Short.MAX_VALUE, nullable = false)
    @FieldAnotation(label = "Password", type = FieldType.PASSWORD, exclusions = {FieldExclusion.LIST, FieldExclusion.SUB_LIST})
    private String password;

    @NotNull
    @Column(length = Short.MAX_VALUE, nullable = false)
    private String salt;

    @FieldAnotation(label = "Profile Image", type = FieldType.ATTACHMENT, exclusions = {FieldExclusion.LIST})
    private Attachment image;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return userName;
    }
}
