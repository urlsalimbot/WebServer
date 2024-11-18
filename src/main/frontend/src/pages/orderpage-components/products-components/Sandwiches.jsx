import baconCheesyMushroom from "./assets/bunwich/bacon_cheesy_mushroom.png";
import cheese from "./assets/bunwich/cheese.png";
import hamNCheese from "./assets/bunwich/ham_and_cheese.png";
import kBun from "./assets/bunwich/k-bun.png";
import spanishSausage from "./assets/bunwich/spanish_sausage.png";
import tuna from "./assets/bunwich/tuna.png";
import "./productTypes.css";
import Item from "../../admin-components/product-components/Item";

export default function Sandwiches({ handleItemClick }) {
  const price = 125;
  return (
    <div className="prodContainer">
      <Item
        name={"Cheese"}
        img={cheese}
        price={price}
        handleItemClick={handleItemClick}
      />
      <Item
        name={"Ham and Cheese"}
        img={hamNCheese}
        price={price}
        handleItemClick={handleItemClick}
      />
      <Item
        name={"Bacon Cheesy Mushroom"}
        img={baconCheesyMushroom}
        price={price}
        handleItemClick={handleItemClick}
      />
      <Item
        name={"K-Bun"}
        img={kBun}
        price={price}
        handleItemClick={handleItemClick}
      />
      <Item
        name={"Spanish Sausage"}
        img={spanishSausage}
        price={price}
        handleItemClick={handleItemClick}
      />
      <Item
        name={"Tuna"}
        img={tuna}
        price={price}
        handleItemClick={handleItemClick}
      />
    </div>
  );
}
