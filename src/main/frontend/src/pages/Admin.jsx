import { useState } from "react";
import styles from "./admin.module.css";
import SectionBtn from "./admin-components/SectionBtn";
import AdminSections from "./admin-components/AdminSections";

export default function Admin() {
  const [section, setSection] = useState("Users And Accounts");

  function handleSecClick(sec) {
    console.log(sec);
    setSection(sec);
  }
  return (
    <div className={styles.adminContainer}>
      <div className={styles.navBar}>
        <SectionBtn
          className={styles.sectionBtn}
          handleSecClick={handleSecClick}
          sectionName={"Users And Accounts"}
        />
        <SectionBtn
          className={styles.sectionBtn}
          handleSecClick={handleSecClick}
          sectionName={"Inventory"}
        />
        <SectionBtn
          className={styles.sectionBtn}
          handleSecClick={handleSecClick}
          sectionName={"Sales"}
        />
      </div>

      <div className={styles.sectionContainer}>
        <AdminSections section={section} />
      </div>
    </div>
  );
}
