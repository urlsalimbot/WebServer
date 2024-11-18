import chocosprinkle from "./assets/classics/choco_sprinkle.png";
import strawberrysprinkle from "./assets/classics/strawberry_sprinkle.png";
import bavarianFilled from "./assets/classics/bavarian_filled.png";
import bostonKreme from "./assets/classics/boston_kreme.png";
import nuttyChoco from "./assets/classics/nutty_choco.png";
import sugarRaised from "./assets/classics/sugar_raised.png";
import vanillaSprinkle from "./assets/classics/vanilla_sprinkle.png";
import chocoMarble from "./assets/classics/choco_marble.png";
import coffeeCrunch from "./assets/classics/coffee_crunch.png";
import coffeeNut from "./assets/classics/coffee_nut.png";
import mellonFrosted from "./assets/classics/mellon_frosted.png";
import nuttyStrawberry from "./assets/classics/nutty_strawberry.png";
import nuttyUbe from "./assets/classics/nutty_ube.png";
import "./productTypes.css";
import Item from "../../admin-components/product-components/Item";

export default function ClassicDonuts({ handleItemClick }) {
  const price = 40;

  return (
    <div className="prodContainer">
      <Item
        name={"Bavarian"}
        img={bavarianFilled}
        price={price}
        handleItemClick={handleItemClick}
        type={"Classic"}
      />
      <Item
        name={"Choco Sprinkle"}
        img={chocosprinkle}
        price={price}
        handleItemClick={handleItemClick}
        type={"Classic"}
      />
      <Item
        name={"Strawberry Sprinkle"}
        img={strawberrysprinkle}
        price={price}
        handleItemClick={handleItemClick}
        type={"Classic"}
      />
      <Item
        name={"Nutty Choco"}
        img={nuttyChoco}
        price={price}
        handleItemClick={handleItemClick}
        type={"Classic"}
      />
      <Item
        name={"Sugar Raised"}
        img={sugarRaised}
        price={price}
        handleItemClick={handleItemClick}
        type={"Classic"}
      />
      <Item
        name={"Vanilla Sprinkle"}
        img={vanillaSprinkle}
        price={price}
        handleItemClick={handleItemClick}
        type={"Classic"}
      />
      <Item
        name={"Choco Marble"}
        img={chocoMarble}
        price={price}
        handleItemClick={handleItemClick}
        type={"Classic"}
      />
      <Item
        name={"Coffee Crunch"}
        img={coffeeCrunch}
        price={price}
        handleItemClick={handleItemClick}
        type={"Classic"}
      />
      <Item
        name={"Coffee Nut"}
        img={coffeeNut}
        price={price}
        handleItemClick={handleItemClick}
        type={"Classic"}
      />
      <Item
        name={"Mellon Frosted"}
        img={mellonFrosted}
        price={price}
        handleItemClick={handleItemClick}
        type={"Classic"}
      />
      <Item
        name={"Nutty Strawberry"}
        img={nuttyStrawberry}
        price={price}
        handleItemClick={handleItemClick}
        type={"Classic"}
      />
      <Item
        name={"Nutty Ube"}
        img={nuttyUbe}
        price={price}
        handleItemClick={handleItemClick}
        type={"Classic"}
      />
      <Item
        name={"Boston Kreme"}
        img={bostonKreme}
        price={price}
        handleItemClick={handleItemClick}
        type={"Classic"}
      />
    </div>
  );
}
