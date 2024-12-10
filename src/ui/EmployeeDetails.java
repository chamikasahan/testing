/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author sahan
 */
@Entity
@Table(name = "employee_details", catalog = "sample_project", schema = "")
@NamedQueries({
    @NamedQuery(name = "EmployeeDetails.findAll", query = "SELECT e FROM EmployeeDetails e")
    , @NamedQuery(name = "EmployeeDetails.findById", query = "SELECT e FROM EmployeeDetails e WHERE e.id = :id")
    , @NamedQuery(name = "EmployeeDetails.findByEmployeeName", query = "SELECT e FROM EmployeeDetails e WHERE e.employeeName = :employeeName")
    , @NamedQuery(name = "EmployeeDetails.findByEmployeeAge", query = "SELECT e FROM EmployeeDetails e WHERE e.employeeAge = :employeeAge")
    , @NamedQuery(name = "EmployeeDetails.findByEmployeeMobile", query = "SELECT e FROM EmployeeDetails e WHERE e.employeeMobile = :employeeMobile")
    , @NamedQuery(name = "EmployeeDetails.findByEmployeeAddress", query = "SELECT e FROM EmployeeDetails e WHERE e.employeeAddress = :employeeAddress")})
public class EmployeeDetails implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "employee_name")
    private String employeeName;
    @Basic(optional = false)
    @Column(name = "employee_age")
    private int employeeAge;
    @Basic(optional = false)
    @Column(name = "employee_mobile")
    private String employeeMobile;
    @Basic(optional = false)
    @Column(name = "employee_address")
    private String employeeAddress;

    public EmployeeDetails() {
    }

    public EmployeeDetails(Integer id) {
        this.id = id;
    }

    public EmployeeDetails(Integer id, String employeeName, int employeeAge, String employeeMobile, String employeeAddress) {
        this.id = id;
        this.employeeName = employeeName;
        this.employeeAge = employeeAge;
        this.employeeMobile = employeeMobile;
        this.employeeAddress = employeeAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        String oldEmployeeName = this.employeeName;
        this.employeeName = employeeName;
        changeSupport.firePropertyChange("employeeName", oldEmployeeName, employeeName);
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(int employeeAge) {
        int oldEmployeeAge = this.employeeAge;
        this.employeeAge = employeeAge;
        changeSupport.firePropertyChange("employeeAge", oldEmployeeAge, employeeAge);
    }

    public String getEmployeeMobile() {
        return employeeMobile;
    }

    public void setEmployeeMobile(String employeeMobile) {
        String oldEmployeeMobile = this.employeeMobile;
        this.employeeMobile = employeeMobile;
        changeSupport.firePropertyChange("employeeMobile", oldEmployeeMobile, employeeMobile);
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        String oldEmployeeAddress = this.employeeAddress;
        this.employeeAddress = employeeAddress;
        changeSupport.firePropertyChange("employeeAddress", oldEmployeeAddress, employeeAddress);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeDetails)) {
            return false;
        }
        EmployeeDetails other = (EmployeeDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ui.EmployeeDetails[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
