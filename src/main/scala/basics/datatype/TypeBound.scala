package basics.datatype

//Type Bound in Scala is like a rule. Type Bound limits what a parameter and variable can be. You can set the limits for the variables in the Scala.
/*
  Types of Type Bounds
  1.UPPER TYPE BOUND (T <: A)
     - An upper type bound limits a type variable to be a subtype of a specific type. It uses the <: operator.
     -T <: A means: "Type T can be A or any subclass of A."
  2.LOWER TYPE BOUND (T >: A)
    - A lower type bound limits a type variable to be a supertype of a specific type. It uses the >: operator.
    - T >: A means: "Type T must be A or a superclass/parent of A."
 */
//
//object  TypeBound extends App {
//
//  trait  Crop {
//    def name:String
//  }
//
//  case class Rice(name:String,waterRequirementLitres:Int ) extends Crop
//  case class Potato(name:String,soilType:String) extends Crop
//  case class Vehicle(model:String)  //Not Crop
//
//  /*
//    - Now, you want to build a CropHarvester class that can process crops. If you make it completely generic ([T]), someone could accidentally pass a Vehicle into it. If you don't use generics at all, you lose the specific type information of what is returned.
//
//    - The Solution: Upper Bound
//    -By using T <: Crop, you guarantee that whatever type is passed into the harvester has access to the Crop methods (like .name), while preventing invalid classes from being used.
//
//   */
//  // T must be a subtype of Crop
//  class CropHarvester[T <: Crop] {
//    def inspect(crop: T): Unit = {
//      println(s"Inspecting crop: ${crop.name}")
//      // Compiles perfectly because the compiler knows T has a .name method
//    }
//  }
//
//  // --- EXECUTION CODE ---
//  // Now these will actually execute and print when you run the object!
//  val riceHarvester = new CropHarvester[Rice]
//  val potatoHarvester = new CropHarvester[Potato]
// // val carHarvester = new CropHarvester[Vehicle]
//  // ❌ Compile Error: Type Vehicle does not conform to bound Crop
//
//  riceHarvester.inspect(Rice("Winter Rice", 1500))
//  potatoHarvester.inspect(Potato("Local Potato", "Alluvial Soil"))
//
//}
object TypeBound {

  trait Crop { def name: String }
  case class Rice(name: String, waterRequirementLitres: Int) extends Crop
  case class Potato(name: String, soilType: String) extends Crop

  class CropHarvester[T <: Crop] {
    def inspect(crop: T): Unit = println(s"Inspecting crop: ${crop.name}")
  }

  // 👈 Scala looks for this exact method signature to trigger the run
  def main(args: Array[String]): Unit = {
    val riceHarvester = new CropHarvester[Rice]
    riceHarvester.inspect(Rice("Autumn Rice", 1200))
  }
}