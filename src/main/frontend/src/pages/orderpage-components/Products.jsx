import ClassicDonuts from "./products-components/ClassicDonuts";
import Drinks from "./products-components/Drinks";
import PremiumDonuts from "./products-components/PremiumDonuts";
import Sandwiches from "./products-components/Sandwiches";
import styles from "./products.module.css";

export default function Products({ prodType }) {
  if (prodType === "Classic Donuts") {
    return <ClassicDonuts />;
  } else if (prodType === "Premium Donuts") {
    return <PremiumDonuts />;
  } else if (prodType === "Drinks") {
    return <Drinks />;
  } else if (prodType === "Munchkins") {
    return <Sandwiches />;
  } else {
    return <div className={styles.productsContainer}>DunkinDonut</div>;
  }
}
