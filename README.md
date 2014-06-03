#jNavigation

Navigation for jMonkey Engine. It will be port for Recast Navigation by Mikko Mononen memon@inside.org. You can find original source code at https://github.com/memononen/recastnavigation .

##Description

###Recast module
Members in this module are used to create mesh data that is then used to create Detour navigation meshes.

The are a large number of possible ways to building navigation mesh data. One of the simple piplines is as follows:
<ol>
<li>Prepare the input triangle mesh.</li>
<li>Build a Heightfield.</li>
<li>Build a CompactHeightfield.</li>
<li>Build a ContourSet.</li>
<li>Build a PolyMesh.</li>
<li>Build a PolyMeshDetail.</li>
<li>Use the PolyMesh and PolyMeshDetail to build a Detour navigation mesh tile.</li>
</ol>
The general life-cycle of the main classes is as follows:
<ol>
<li>initializeStructure with appropriate Builder class</li>
<li>build or create structure with Builder class</li>
<li>Update the object as needed. (E.g. rasterizeTriangles)</li>
<li>Use the object as part of the pipeline.</li>
</ol>

###Detour module
Members in this module are used to create, manipulate, and query navigation meshes.

A navigation mesh based on tiles of convex polygons.

The navigation mesh consists of one or more tiles defining three primary types of structural data:
<ul>
<li>A polygon mesh which defines most of the navigation graph. (See PolyMesh for its structure.)</li>
<li>A detail mesh used for determining surface height on the polygon mesh. (See PolyMeshDetail for its structure.)</li>
<li>Off-mesh connections, which define custom point-to-point edges within the navigation graph.</li>
</ul>

The general build process is as follows:
<ol>
<li>Create PolyMesh and PolyMeshDetail data using the Recast build pipeline.</li>
<li>Combine the source data into a NavMeshCreateParams structure.</li>
<li>Create a tile data array using CreateNavMeshData().</li>
<li>Allocate at NavMesh object and initialize it. (For single tile navigation meshes, the tile data is loaded during this step.)</li>
<li>For multi-tile navigation meshes, load the tile data using NavMesh#addTile().</li>
</ol>

####Notes:
This class is usually used in conjunction with the NavMeshQuery class for pathfinding.
Technically, all navigation meshes are tiled. A 'solo' mesh is simply a navigation mesh initialized to have only a single tile.
This class does not implement any asynchronous methods. So the Status result of all methods will always contain either a success or failure flag.