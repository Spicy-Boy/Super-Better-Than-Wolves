package net.minecraft.src;

public class SuperBTWItemRibCarvingIron extends SuperBTWItemBladeProgressive
{
	
	static int internalBladeDamage;
	
	public SuperBTWItemRibCarvingIron(int iItemID) {
		super(iItemID);
		// TODO Auto-generated constructor stub
	    	
	    setUnlocalizedName( "SuperBTWItemRibCarvingIron" );  
	    
	    setMaxDamage( GetProgressiveCraftingMaxDamage() );
	    
	 }
	
	 protected int GetProgressiveCraftingMaxDamage() //how long it takes... don't forget to match value from RecipesRibCarving!
	 {
	    return 75;
	 }
	 
	 protected void PlayCraftingFX( ItemStack stack, World world, EntityPlayer player )
	 {
	    	//worldObj.playAuxSFX( FCBetterThanWolves.m_iCreeperNeuteredAuxFXID, i, j, k, 0 );
	        player.playSound( "mob.slime.small", 
	        	0.25F + 0.25F * (float)world.rand.nextInt( 2 ), 
	        	( world.rand.nextFloat() - world.rand.nextFloat() ) * 0.25F + 1.75F );
	 }
	 
	 public ItemStack onEaten( ItemStack stack, World world, EntityPlayer player )
	 {
	    	ItemStack leatherWorking = new ItemStack( SuperBTWDefinitions.ribCarvingIron, 1);
	    	
	        world.playSoundAtEntity( player, "step.cloth", 1.0F, world.rand.nextFloat() * 0.1F + 0.9F );
	        
			//FCUtilsItem.GivePlayerStackOrEject( player, leatherWorking );
	        
	        int internalBladeDamage;
	        
	        internalBladeDamage = stack.getTagCompound().getInteger("damage") + 1;
	        
	        if (internalBladeDamage >= 76)
	        {
	        	
	        }
	        else
	        {
	        	FCUtilsItem.GivePlayerStackOrEject( player, new ItemStack(SuperBTWDefinitions.ironBlade, 1, internalBladeDamage));
	        	FCUtilsItem.GivePlayerStackOrEject( player, new ItemStack(Item.beefRaw, 1));
	        }
	        
	        
			
	        return new ItemStack( SuperBTWDefinitions.rib, 1);
	 }
	    
	 public void onCreated( ItemStack stack, World world, EntityPlayer player ) 
	 {
		 super.onCreated( stack, world, player );
		 
	 }
	 


}
